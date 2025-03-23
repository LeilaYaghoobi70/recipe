package app.google.presenter.arch

import app.google.coremodule.businessModel.MealInstruction

data class MealState(
    val mealInstruction: List<MealInstruction>? = null
)