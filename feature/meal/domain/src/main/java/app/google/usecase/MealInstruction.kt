package app.google.usecase

import app.google.coremodule.businessModel.MealInstruction
import app.google.repository.MealRepository
import javax.inject.Inject

class MealInstruction
@Inject constructor(
    private val mealRepository: MealRepository
) {
    suspend fun invoke(letter: String): List<MealInstruction>? =
        mealRepository.getMealInstructions(letter = letter)

}