package app.google.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MealCategoryResponse(
    @SerialName("strCategory")
    val strCategory: String
)

@Serializable
data class CategoriesResponse(
    @SerialName("meals")
    val meals: List<MealCategoryResponse>
)


