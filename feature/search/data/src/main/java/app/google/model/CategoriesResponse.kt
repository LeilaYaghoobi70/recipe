package app.google.model

import kotlinx.serialization.SerialName


data class MealCategoryResponse(
    @SerialName("strCategory")
    val strCategory: String
)

data class CategoriesResponse(
    @SerialName("meals")
    val meals: List<MealCategoryResponse>
)


