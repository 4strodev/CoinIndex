package cat.dam.astrodev.coingecko.features.coins.services

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.*;
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.request.parameter
import io.ktor.serialization.kotlinx.json.json

class CoingeckoService {
    private val API_KEY = "CG-cxaYxWmmtsLuTazQk3uHA4rQ"
    private val BASE_URL = "https://api.coingecko.com/api/v3"
    private val client = HttpClient(OkHttp) {
        install(Logging)
        install(ContentNegotiation) {
            json()
        }
    }


    suspend fun getCoins(perPage: Int, page: Int): List<CoinMarketData> {
        val response = this.client.get("$BASE_URL/coins/markets") {
            url {
                parameter("vs_currency", "eur")
                parameter("order", "market_cap_desc")
                parameter("per_page", perPage)
                parameter("page", page)
            }
            headers {
                append("x-cg-demo-api-key", API_KEY)
            }
        }

        return response.body()
    }
}