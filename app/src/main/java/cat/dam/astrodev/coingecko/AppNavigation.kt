package cat.dam.astrodev.coingecko

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import cat.dam.astrodev.coingecko.features.coins.screens.coinlist.CoinList
import cat.dam.astrodev.coingecko.shared.layouts.MainScaffoldLayout
import cat.dam.astrodev.coingecko.shared.screens.Home

@Composable
fun AppNavigation(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = "coinList") {
        composable("home") {
            MainScaffoldLayout(titleFactory = {
                "Home"
            }) {
                Home(navHostController)
            }
        }

        composable("coinList") {
            MainScaffoldLayout(titleFactory = {
                "Coin list"
            }) {
                CoinList(navHostController)
            }
        }
    }
}