package app.google.presenter.meal.arch

sealed class MealEvent {
    data class GetMeal(
        val categoryId: String
    ) : MealEvent()
}
