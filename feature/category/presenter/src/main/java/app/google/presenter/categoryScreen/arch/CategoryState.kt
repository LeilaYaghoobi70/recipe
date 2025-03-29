package app.google.presenter.categoryScreen.arch
import app.google.model.SpecialCategory

data class CategoryState (
    val categories: List<Pair<String, Boolean>> = emptyList(),
    val specialCategories: List<SpecialCategory> = emptyList(),
    val showError: Boolean = false,
    val showCategoryLoading: Boolean = false,
    val showSpecialCategoryLoading: Boolean = false
)
