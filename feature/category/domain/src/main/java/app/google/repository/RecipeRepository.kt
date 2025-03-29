package app.google.repository

import app.google.model.Categories
import app.google.model.SpecialCategory


interface RecipeRepository {
    suspend fun getCategories(): Categories
    suspend fun getSpecialCategory(categoryName: String): List<SpecialCategory>
}