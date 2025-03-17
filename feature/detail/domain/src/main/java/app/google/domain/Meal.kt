package app.google.domain

data class MealInstruction(
    val id: String,
    val name: String,
    val alternateName: String? = null,
    val category: String,
    val area: String,
    val instructions: String,
    val thumbnail: String,
    val tags: String? = null,
    val youtubeUrl: String? = null,
    val source: String? = null
)


data class Meal(
    val mealInstructions: List<MealInstruction>
)