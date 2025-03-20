package app.google.usecase

import app.google.model.MealInstruction
import app.google.repository.RecipeRepository
import javax.inject.Inject

class GetCategoryMeal @Inject constructor(
    private val recipeRepository: RecipeRepository
) {
    suspend fun invoke(categoryId: String): MealInstruction {
       return recipeRepository.getCategoryMeal(categoryId = categoryId)
    }
}