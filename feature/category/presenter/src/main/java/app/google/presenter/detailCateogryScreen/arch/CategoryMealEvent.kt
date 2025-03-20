package app.google.presenter.detailCateogryScreen.arch

sealed class CategoryMealEvent {
    data class GetCategoryMeal(
        val categoryId: String
    ) : CategoryMealEvent()
}
