package app.google.presenter.arch

sealed class MealEvent {
    data class Search(val letter: String): MealEvent()
    data class GetMeal(val name: String): MealEvent()
}