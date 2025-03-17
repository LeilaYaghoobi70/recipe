package app.google.usecase

import app.google.model.Categories
import app.google.repository.RecipeRepository
import javax.inject.Inject


class GetCategories @Inject constructor(
    private val recipeRepository: RecipeRepository
) {
    suspend fun invoke(): Categories =
        recipeRepository.getCategories()
}