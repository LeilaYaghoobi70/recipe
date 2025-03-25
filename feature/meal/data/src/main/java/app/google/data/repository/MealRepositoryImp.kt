package app.google.data.repository

import app.google.data.model.toMealInstruction
import app.google.data.mealApiService.MealApiService
import app.google.model.MealInstruction

import app.google.repository.MealRepository
import javax.inject.Inject

class MealRepositoryImp @Inject constructor(
    private val mealApiService: MealApiService
) : MealRepository {
    override suspend fun getMealInstructions(letter: String): List<MealInstruction>? =
        mealApiService.getMealInstruction(letter = letter).meals?.map { it.toMealInstruction() }

    override suspend fun getMealInstruction(id: String): MealInstruction? =
        mealApiService.getCategoryMeal(id).meals?.firstOrNull()?.toMealInstruction()
}
