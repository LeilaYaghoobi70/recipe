package app.google.usecase

import app.google.model.SpecialCategories
import app.google.repository.RecipeRepository
import javax.inject.Inject

class GetSpecialCategory @Inject constructor(
    private val recipeRepository: RecipeRepository
) {
    suspend fun invoke(categoryName: String): SpecialCategories =
        recipeRepository.getSpecialCategory(categoryName = categoryName)
}