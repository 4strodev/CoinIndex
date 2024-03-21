package cat.dam.astrodev.coingecko.features.coins.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import cat.dam.astrodev.coingecko.features.coins.services.CoinMarketData
import coil.compose.AsyncImage

@Composable
fun CoinCard(coinMarketData: CoinMarketData) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                AsyncImage(modifier = Modifier
                    .weight(.15f)
                    .aspectRatio(1f), model = coinMarketData.image, contentDescription = null)
                Spacer(modifier = Modifier.weight(.05f))
                Text(modifier = Modifier.weight(1f), text = coinMarketData.name, style = MaterialTheme.typography.headlineSmall)
                Text("${coinMarketData.currentPrice} €")
                var arrow: ImageVector = Icons.Default.KeyboardArrowUp
                var color = Color.Green
                if ((coinMarketData.priceChange24h ?: 0.0) < 0.0) {
                    arrow = Icons.Default.KeyboardArrowDown
                    color = Color.Red
                }
                Icon(imageVector = arrow, contentDescription = null, tint = color)
            }
        }
    }
}