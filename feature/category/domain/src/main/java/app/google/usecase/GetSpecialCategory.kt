package app.google.usecase

import app.google.model.SpecialCategory
import app.google.repository.RecipeRepository
import javax.inject.Inject

class GetSpecialCategory @Inject constructor(
    private val recipeRepository: RecipeRepository
) {
    suspend fun invoke(categoryName: String): List<SpecialCategory> =
        recipeRepository.getSpecialCategory(categoryName = categoryName)
}