package app.google.model


data class SpecialCategory(
    val id: String,
    val name: String,
    val thumbnail: String
)


data class SpecialCategories(
    val specialCategories: List<SpecialCategory>
)