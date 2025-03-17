package app.google.repository

import app.google.RecipeApiService
import app.google.model.Categories
import app.google.model.SpecialCategories
import app.google.model.getCategories

class RecipeRepositoryImp(
    private val recipeApiService: RecipeApiService
) : RecipeRepository {
    override suspend fun getCategories(): Categories {
        return recipeApiService.getCategories().getCategories()
    }

    override suspend fun getSpecialCategory(categoryName: String): SpecialCategories {
        return recipeApiService.getSpecialCategory(categoryName = categoryName).SpecialCategories()
    }
}