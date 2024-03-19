package cat.dam.astrodev.coingecko

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cat.dam.astrodev.coingecko.ui.theme.CoingeckoTheme

@Composable
fun AppSurface(content: @Composable () -> Unit) {
    CoingeckoTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            content()
        }
    }
}