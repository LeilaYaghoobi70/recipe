package app.google.presenter.categoryScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.google.presenter.categoryScreen.arch.CategoryEvent
import app.google.presenter.categoryScreen.arch.CategoryState
import app.google.usecase.GetCategories
import app.google.usecase.GetSpecialCategory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val getSpecialCategory: GetSpecialCategory,
    private val getCategories: GetCategories,
) : ViewModel() {

    private val _state = MutableStateFlow(CategoryState())
    val state: StateFlow<CategoryState> = _state.stateIn(
        viewModelScope,
        SharingStarted.Eagerly,
        CategoryState()
    )

    private val exceptionHandler = CoroutineExceptionHandler { _, _ ->
        _state.update {
            it.copy(
                showError = true
            )
        }
    }

    init {
        initializeCategories()
    }

    fun handleEvent(event: CategoryEvent) {
        if (event is CategoryEvent.GetSpecialCategory) {
            loadSpecialCategory(event.name)
        }
    }

    private fun initializeCategories() {
        viewModelScope.launch(exceptionHandler) {
            _state.update { it.copy(showCategoryLoading = true, showSpecialCategoryLoading = true) }

            val categories = getCategories.invoke()
            val firstCategory = categories.meals.firstOrNull() ?: return@launch

            _state.update { it.copy(categories = categories.meals.map { name -> name to (name == firstCategory) }) }

            fetchSpecialCategory(firstCategory)
        }
    }

    private fun loadSpecialCategory(categoryName: String) {
        updateSelectedCategory(categoryName)
        fetchSpecialCategory(categoryName)
    }

    private fun updateSelectedCategory(categoryName: String) {
        _state.update { it.copy(categories = it.categories.map { (name, _) -> name to (name == categoryName) }) }
    }

    private fun fetchSpecialCategory(categoryName: String) {
        viewModelScope.launch(exceptionHandler) {
            _state.update { it.copy(showSpecialCategoryLoading = true) }

            val specialCategory = getSpecialCategory.invoke(categoryName)

            _state.update {
                it.copy(
                    specialCategories = specialCategory,
                    showSpecialCategoryLoading = false,
                    showCategoryLoading = false
                )
            }
        }
    }
}
