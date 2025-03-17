package app.google


import app.google.model.CategoriesResponse
import app.google.model.SpecialCategories
import app.google.model.SpecialCategoriesResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.Url

class RecipeApiService(
    private val httpClient: HttpClient
) {
    companion object {
        private const val END_POINT = "www.themealdb.com/api/json/v1/1"
        private const val CATEGORIES_END_POINT = END_POINT + "list.php?c=list"
        private const val SPECIAL_CATEGORIES_END_POINT = END_POINT + "filter.php?c=Seafood"
    }

    suspend fun getCategories(): CategoriesResponse =
        httpClient.get(CATEGORIES_END_POINT).body<CategoriesResponse>()

    suspend fun getSpecialCategory(categoryName: String): SpecialCategoriesResponse =
        httpClient.get {
            Url(SPECIAL_CATEGORIES_END_POINT)
            parameter("c", categoryName)
        }.body<SpecialCategoriesResponse>()
}