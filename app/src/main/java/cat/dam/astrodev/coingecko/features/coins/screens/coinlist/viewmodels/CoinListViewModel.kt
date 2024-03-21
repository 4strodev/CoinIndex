package cat.dam.astrodev.coingecko.features.coins.screens.coinlist.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import cat.dam.astrodev.coingecko.features.coins.services.CoinMarketData
import cat.dam.astrodev.coingecko.features.coins.services.CoingeckoService
import java.lang.Exception

class CoinListViewModel : ViewModel() {
    var fetchingData by mutableStateOf(false)
        private set
    private val coingeckoService = CoingeckoService()
    private var pageSize by mutableIntStateOf(100)
    private var pageNumber by mutableIntStateOf(1)
    val coinList = mutableStateListOf<CoinMarketData>()
    var endReached by mutableStateOf(false)
        private set

    suspend fun getNextPage() {
        try {
            fetchingData = true
            val coinList = this.coingeckoService.getCoins(this.pageNumber, this.pageSize)
            this.coinList.addAll(coinList)
//            endReached = coinList.isEmpty()
            this.pageNumber ++
        } catch (e: Exception) {
            throw e
        } finally {
            fetchingData = false
        }

    }
}