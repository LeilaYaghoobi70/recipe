package app.google.repository

import app.google.CategoryApiService
import app.google.coremodule.businessModel.MealInstruction
import app.google.coremodule.mapper.toMealInstruction
import app.google.model.Categories
import app.google.model.SpecialCategories
import app.google.model.getCategories
import javax.inject.Inject

class RecipeRepositoryImp @Inject constructor(
    private val categoryApiService: CategoryApiService
) : RecipeRepository {
    override suspend fun getCategories(): Categories {
        return categoryApiService.getCategories().getCategories()
    }

    override suspend fun getSpecialCategory(categoryName: String): SpecialCategories {
        return categoryApiService.getSpecialCategory(categoryName = categoryName).SpecialCategories()
    }

    override suspend fun getCategoryMeal(categoryId: String): MealInstruction? {
        return categoryApiService.getCategoryMeal(categoryId = categoryId).meals?.first()?.toMealInstruction()
    }
}