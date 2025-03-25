package app.google.usecase

import app.google.model.MealInstruction
import app.google.repository.MealRepository
import javax.inject.Inject

class GetMeal @Inject constructor(
    private val recipeRepository: MealRepository
) {
    suspend fun invoke(categoryId: String): MealInstruction? {
       return recipeRepository.getMealInstruction(id = categoryId)
    }
}