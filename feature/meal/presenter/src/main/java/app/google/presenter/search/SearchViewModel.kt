package app.google.presenter.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.google.presenter.search.arch.SearchEvent
import app.google.presenter.search.arch.SearchState
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
class SearchViewModel @Inject constructor(
    private val mealInstruction: MealInstruction,
): ViewModel() {

    private val _state = MutableStateFlow(SearchState())
    val state = _state.stateIn(
        viewModelScope,
        SharingStarted.Eagerly,
        SearchState()
    )


    fun handleEvent(searchEvent: SearchEvent){
        when(searchEvent){
            is SearchEvent.Search -> (getMealInstruction(searchEvent.letter))
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