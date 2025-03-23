package app.google.coremodule.mapper

import app.google.coremodule.businessModel.MealInstruction
import app.google.coremodule.networkModel.MealInstructionResponse

fun MealInstructionResponse.toMealInstruction(): MealInstruction {
    return MealInstruction(
        id = id,
        name = name,
        alternateName = alternateName,
        category = category,
        area = area,
        instructions = instructions,
        thumbnail = thumbnail,
        tags = tags,
        youtubeUrl = youtubeUrl,
        source = source
    )
}