package app.google.repository

import app.google.coremodule.businessModel.MealInstruction
import app.google.model.Categories

import app.google.model.SpecialCategories

interface RecipeRepository {
    suspend fun getCategories(): Categories
    suspend fun getSpecialCategory(categoryName: String): SpecialCategories
    suspend fun getCategoryMeal(categoryId: String): MealInstruction?
}