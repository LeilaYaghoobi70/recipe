package app.google.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class SpecialCategoryResponse(
    @SerialName("idMeal") val id: String,
    @SerialName("strMeal") val name: String,
    @SerialName("strMealThumb") val thumbnail: String
)

@Serializable
data class SpecialCategoriesResponse(
    @SerialName("meals")
    val meals: List<SpecialCategoryResponse>
)