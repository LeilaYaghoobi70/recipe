package app.google.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.google.model.SpecialCategories
import app.google.presenter.arch.CategoryState
import app.google.usecase.GetCategories
import app.google.usecase.GetSpecialCategory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val getSpecialCategory: GetSpecialCategory,
    private val getCategories: GetCategories,
) : ViewModel() {

    private val _state = MutableStateFlow(CategoryState())
    val state = _state.stateIn(
        viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = CategoryState()
    )

    init {
        viewModelScope.launch {
            val categories = getCategories.invoke()
            val specialCategories = getSpecialCategory.invoke(categoryName = categories.meals[0])
            _state.update {
                it.copy(
                    categories = categories.meals.mapIndexed { index, s -> Pair(s, index == 0) },
                    specialCategories = specialCategories
                )
            }
        }
    }

    private fun getSpecialCategory(categoryName: String) {
        viewModelScope.launch {
            getSpecialCategory.invoke(categoryName = categoryName)
        }
    }

}