package app.google.data.mealApiService

import app.google.data.model.MealResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import javax.inject.Inject

class MealApiService @Inject constructor(
    private val httpClient: HttpClient
) {

    companion object{
        private const val END_POINT = "https://www.themealdb.com/api/json/v1/1/"
        private const val SEARCH_MEAL = END_POINT + "search.php"
        private const val CATEGORY_MEAL = END_POINT + "lookup.php"
    }

    suspend fun getMealInstruction(letter: String): MealResponse = httpClient.get(
        SEARCH_MEAL
    ){
        parameter("f",letter)
    }.body<MealResponse>()

    suspend fun getCategoryMeal(categoryId: String): MealResponse =
        httpClient.get(CATEGORY_MEAL){
            parameter("i",categoryId)
        }.body<MealResponse>()
}