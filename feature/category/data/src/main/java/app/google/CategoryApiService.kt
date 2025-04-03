package app.google


import app.google.common.network.Endpoint
import app.google.common.network.fetchData
import app.google.model.CategoriesResponse
import app.google.model.SpecialCategoriesResponse
import io.ktor.client.HttpClient
import javax.inject.Inject


class CategoryApiService @Inject constructor(
    private val httpClient: HttpClient
) {
    suspend fun getCategories(): CategoriesResponse =
        httpClient.fetchData(Endpoint(path = "list.php?c=list"))

    suspend fun getSpecialCategory(categoryName: String): SpecialCategoriesResponse =
        httpClient.fetchData(Endpoint(path = "filter.php", mapOf("c" to categoryName)))
}
