package cat.dam.astrodev.coingecko.shared.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import cat.dam.astrodev.coingecko.AppSurface
import cat.dam.astrodev.coingecko.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import cat.dam.astrodev.coingecko.shared.composables.AnimationItem

@Composable
fun Home(navController: NavController) {
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AnimationItem(
            animationResId = R.raw.bitcoin_wallet_animation,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f),
            callback = {
                scope.launch {
                    delay(3000)
                    navController.navigate("coinList")
                }
            }
        )
    }
}

@Preview
@Composable
fun HomePreview() {
    AppSurface {
        Home(navController = rememberNavController())
    }
}