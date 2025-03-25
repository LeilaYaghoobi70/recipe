package app.google.data.model

import app.google.model.MealInstruction


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