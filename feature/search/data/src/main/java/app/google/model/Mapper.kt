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
