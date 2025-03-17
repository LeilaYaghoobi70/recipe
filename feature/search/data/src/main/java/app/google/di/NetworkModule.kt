package app.google.di


import android.util.Log
import app.google.RecipeApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.observer.ResponseObserver
import io.ktor.client.request.accept
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import javax.inject.Singleton


private const val NETWORK_TIME_OUT = 6_000L

@Module
@InstallIn(ActivityComponent::class)
class NetworkModule {

    @Provides
    fun provideHttpClient(): HttpClient {
        return httpClientAndroid
    }

    @Provides
    @Singleton
    fun provideApiService(httpClient: HttpClient): RecipeApiService {
        return RecipeApiService(httpClient)
    }

    private val httpClientAndroid = HttpClient(Android) {
        install(ContentNegotiation) {
            json(
                Json {
                    prettyPrint = true
                    isLenient = true
                    useAlternativeNames = true
                    ignoreUnknownKeys = true
                    encodeDefaults = false
                }
            )
        }

        install(HttpTimeout) {
            requestTimeoutMillis = NETWORK_TIME_OUT
            connectTimeoutMillis = NETWORK_TIME_OUT
            socketTimeoutMillis = NETWORK_TIME_OUT
        }

        Logging {
            logger = object : Logger {
                override fun log(message: String) { Log.i("Logger Ktor =>", message) }
            }
            level = LogLevel.ALL
        }
        ResponseObserver { httpResponse ->
            Log.i("HTTP status:", "${httpResponse.status.value}")

        }
        defaultRequest {
            contentType(ContentType.Application.Json)
            accept(ContentType.Application.Json)
            header(HttpHeaders.ContentType, ContentType.Application.Json)
        }
    }
}