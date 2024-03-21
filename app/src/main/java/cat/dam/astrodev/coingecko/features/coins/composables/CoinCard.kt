package cat.dam.astrodev.coingecko.features.coins.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cat.dam.astrodev.coingecko.features.coins.services.CoinMarketData

@Composable
fun CoinCard(coinMarketData: CoinMarketData) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)) {
            Text(coinMarketData.name, style = MaterialTheme.typography.headlineSmall)
        }
    }
}