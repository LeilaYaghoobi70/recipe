package app.google.presenter.categoryScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.google.presenter.categoryScreen.arch.CategoryEvent
import app.google.presenter.categoryScreen.arch.CategoryState
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
        SharingStarted.Eagerly,
        CategoryState()
    )

    init {
        initializeCategories()
    }

    fun handleEvent(event: CategoryEvent) {
        when (event) {
            is CategoryEvent.GetSpecialCategory -> loadSpecialCategory(event.name)
        }
    }

    private fun initializeCategories() {
        viewModelScope.launch {
            val categories = getCategories.invoke()
            val firstCategory = categories.meals.firstOrNull() ?: return@launch
            val specialCategories = getSpecialCategory.invoke(firstCategory)

            _state.update {
                it.copy(
                    categories = categories.meals.map { name -> name to (name == firstCategory) },
                    specialCategories = specialCategories
                )
            }
        }
    }

    private fun loadSpecialCategory(categoryName: String) {
        updateSelectedCategory(categoryName)
        fetchSpecialCategory(categoryName)
    }

    private fun updateSelectedCategory(categoryName: String) {
        _state.update { state ->
            state.copy(
                categories = state.categories.map { (name, _) -> name to (name == categoryName) }
            )
        }
    }

    private fun fetchSpecialCategory(categoryName: String) {
        viewModelScope.launch {
            val specialCategory = getSpecialCategory.invoke(categoryName)
            _state.update { it.copy(specialCategories = specialCategory) }
        }
    }
}
