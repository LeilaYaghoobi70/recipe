package app.google.repository

import app.google.coremodule.businessModel.MealInstruction


interface MealRepository {
    suspend fun getMealInstructions(letter: String): List<MealInstruction>?
}