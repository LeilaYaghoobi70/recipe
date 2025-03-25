package app.google.repository

import app.google.model.MealInstruction


interface MealRepository {
    suspend fun getMealInstructions(letter: String): List<MealInstruction>?
    suspend fun getMealInstruction(id: String): MealInstruction?
}