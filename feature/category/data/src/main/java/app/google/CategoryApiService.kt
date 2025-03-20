package app.google


import app.google.model.CategoriesResponse
import app.google.model.MealResponse
import app.google.model.SpecialCategoriesResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import javax.inject.Inject

class CategoryApiService @Inject constructor(
    private val httpClient: HttpClient
) {
    companion object {
        private const val END_POINT = "https://www.themealdb.com/api/json/v1/1/"
        private const val CATEGORIES_END_POINT = END_POINT + "list.php?c=list"
        private const val SPECIAL_CATEGORIES_END_POINT = END_POINT + "filter.php"
        private const val CATEGORY_MEAL = END_POINT + "lookup.php"
    }

    suspend fun getCategories(): CategoriesResponse =
        httpClient.get(CATEGORIES_END_POINT).body<CategoriesResponse>()

    suspend fun getSpecialCategory(categoryName: String): SpecialCategoriesResponse =
        httpClient.get(SPECIAL_CATEGORIES_END_POINT){
            parameter("c", categoryName)
        }.body<SpecialCategoriesResponse>()

    suspend fun getCategoryMeal(categoryId: String): MealResponse =
        httpClient.get(CATEGORY_MEAL){
            parameter("i",categoryId)
        }.body<MealResponse>()
}