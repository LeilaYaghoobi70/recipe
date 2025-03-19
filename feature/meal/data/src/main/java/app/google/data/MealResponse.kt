package app.google.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Meal(
    @SerialName("idMeal") val id: String,
    @SerialName("strMeal") val name: String,
    @SerialName("strMealAlternate") val alternateName: String? = null,
    @SerialName("strCategory") val category: String,
    @SerialName("strArea") val area: String,
    @SerialName("strInstructions") val instructions: String,
    @SerialName("strMealThumb") val thumbnail: String,
    @SerialName("strTags") val tags: String? = null,
    @SerialName("strYoutube") val youtubeUrl: String? = null,
    @SerialName("strSource") val source: String? = null
)

@Serializable
data class MealResponse(
    val meals: List<Meal>
)
