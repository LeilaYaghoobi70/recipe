package app.google.presenter.search.arch

import app.google.model.MealInstruction

data class SearchState(
    val mealInstruction: List<MealInstruction>? = null
)