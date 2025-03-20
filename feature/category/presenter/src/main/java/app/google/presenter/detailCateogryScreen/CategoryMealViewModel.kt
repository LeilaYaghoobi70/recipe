package app.google.presenter.detailCateogryScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.google.presenter.detailCateogryScreen.arch.CategoryMealEvent
import app.google.presenter.detailCateogryScreen.arch.CategoryMealState
import app.google.usecase.GetCategoryMeal
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryMealViewModel @Inject constructor(
    private val getCategoryMeal: GetCategoryMeal
) : ViewModel() {
    private val _state = MutableStateFlow(CategoryMealState())
    val state = _state.stateIn(
        viewModelScope,
        SharingStarted.Eagerly,
        CategoryMealState()
    )

    fun handleEvent(categoryMealEvent: CategoryMealEvent){
        when(categoryMealEvent){
            is CategoryMealEvent.GetCategoryMeal -> getCategoryMealCategory(categoryMealEvent.categoryId)
        }
    }

    private fun getCategoryMealCategory(categoryId: String) {
        viewModelScope.launch {
           val mealInstruction =  getCategoryMeal.invoke(categoryId)
            _state.update {
                it.copy(
                    mealInstruction = mealInstruction
                )
            }
        }
    }
}