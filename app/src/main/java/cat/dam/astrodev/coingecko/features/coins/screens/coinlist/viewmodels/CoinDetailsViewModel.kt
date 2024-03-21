package cat.dam.astrodev.coingecko.features.coins.screens.coinlist.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class CoinDetailsViewModel {
    var id by mutableStateOf("")
    companion object {
        val instance = CoinDetailsViewModel()
    }
}