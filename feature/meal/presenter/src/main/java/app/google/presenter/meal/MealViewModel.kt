package app.google.presenter.meal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.google.presenter.meal.arch.MealEvent
import app.google.presenter.meal.arch.MealState
import app.google.usecase.GetMeal
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealViewModel @Inject constructor(
    private val getMeal: GetMeal
) : ViewModel() {
    private val _state = MutableStateFlow(MealState())
    val state = _state.stateIn(viewModelScope, SharingStarted.Eagerly, MealState())

    fun handleEvent(categoryMealEvent: MealEvent) {
        when (categoryMealEvent) {
            is MealEvent.GetMeal -> getCategoryMealCategory(mealId = categoryMealEvent.categoryId)
        }
    }

    private fun getCategoryMealCategory(mealId: String) {
        viewModelScope.launch {
            val mealInstruction = getMeal.invoke(mealId)
            _state.update {
                it.copy(
                    mealInstruction = mealInstruction
                )
            }
        }
    }
}
