package app.google.common.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

suspend inline fun <reified T> HttpClient.fetchData(endpoint: Endpoint): T {
    return get(endpoint.url) {
        endpoint.parameters?.forEach { (key, value) ->
            parameter(key, value)
        }
    }.body()
}