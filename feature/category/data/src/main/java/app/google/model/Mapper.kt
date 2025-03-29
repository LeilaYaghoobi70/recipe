package app.google.model


fun CategoriesResponse.getCategories(): Categories {
    return Categories(
        meals.map { it.strCategory }
    )
}

fun SpecialCategoriesResponse.SpecialCategories(): List<SpecialCategory> {
    return meals.map {
            SpecialCategory(it.id, it.name, it.thumbnail)
        }
}
