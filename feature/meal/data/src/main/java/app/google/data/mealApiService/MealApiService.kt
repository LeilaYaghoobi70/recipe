package app.google.data.mealApiService

import app.google.common.network.Endpoint
import app.google.common.network.fetchData
import app.google.data.model.MealResponse
import io.ktor.client.HttpClient
import javax.inject.Inject

class MealApiService @Inject constructor(
    private val httpClient: HttpClient
) {

    suspend fun getMealInstruction(letter: String): MealResponse =
        httpClient.fetchData(endpoint = Endpoint(path = "search.php", mapOf("f" to letter)))

    suspend fun getCategoryMeal(categoryId: String): MealResponse =
        httpClient.fetchData(endpoint = Endpoint(path = "lookup.php", mapOf("i" to categoryId)))
}