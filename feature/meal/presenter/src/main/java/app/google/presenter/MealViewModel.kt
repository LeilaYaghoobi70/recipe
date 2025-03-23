package app.google.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.google.presenter.arch.MealEvent
import app.google.presenter.arch.MealState
import app.google.usecase.MealInstruction
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealViewModel @Inject constructor(
    private val mealInstruction: MealInstruction,
): ViewModel() {

    private val _state = MutableStateFlow(MealState())
    val state = _state.stateIn(
        viewModelScope,
        SharingStarted.Eagerly,
        MealState()
    )


    fun handleEvent(mealEvent: MealEvent){
        when(mealEvent){
            is MealEvent.GetMeal -> TODO()
            is MealEvent.Search -> (getMealInstruction(mealEvent.letter))
        }

    }
    private fun getMealInstruction(
        letter: String
    ) {
        if (letter.isEmpty()){
            _state.update {
                it.copy(mealInstruction = null)
            }
            return
        }

        viewModelScope.launch(CoroutineExceptionHandler { _, _ ->  }) {
            val mealInstructions = mealInstruction.invoke(letter)
            _state.update {
                it.copy(mealInstruction = mealInstructions)
            }
        }
    }
}