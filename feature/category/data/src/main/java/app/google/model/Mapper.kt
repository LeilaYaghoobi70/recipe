package app.google.model

fun CategoriesResponse.getCategories(): Categories {
    return Categories(
        meals.map { it.strCategory }
    )
}

fun SpecialCategoriesResponse.SpecialCategories(): SpecialCategories {
    return SpecialCategories(
        meals.map {
            SpecialCategory(it.id, it.name, it.thumbnail)
        }
    )
}
fun MealInstructionResponse.MealInstruction(): MealInstruction {
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
