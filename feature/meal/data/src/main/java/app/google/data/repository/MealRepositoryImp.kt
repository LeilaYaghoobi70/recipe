package app.google.data.repository

import app.google.coremodule.businessModel.MealInstruction
import app.google.coremodule.mapper.toMealInstruction
import app.google.data.mealApiService.MealApiService

import app.google.repository.MealRepository
import javax.inject.Inject

class MealRepositoryImp @Inject constructor(
    private val mealApiService: MealApiService
) : MealRepository {
    override suspend fun getMealInstructions(letter: String): List<MealInstruction>? =
        mealApiService.getMealInstruction(letter = letter).meals?.map { it.toMealInstruction() }
}
