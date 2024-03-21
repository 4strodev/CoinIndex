package cat.dam.astrodev.coingecko

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import cat.dam.astrodev.coingecko.features.coins.screens.coinlist.CoinList
import cat.dam.astrodev.coingecko.shared.layouts.MainScaffoldLayout
import cat.dam.astrodev.coingecko.shared.screens.Home
import cat.dam.astrodev.coingecko.shared.screens.Info
import cat.dam.astrodev.coingecko.shared.screens.Splash

@Composable
fun AppNavigation(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = "splash") {
        composable("splash") {
            MainScaffoldLayout(
                titleFactory = { "Splash" },
                navController = navHostController
            ) {
                Splash(navController = navHostController)
            }
        }

        composable("home") {
            MainScaffoldLayout(
                titleFactory = { "Home" },
                navController = navHostController
            ) {
                Home(navController = navHostController)
            }
        }

        composable("coinList") {
            MainScaffoldLayout(
                titleFactory = { "Coin list" },
                navController = navHostController
            ) {
                CoinList(navHostController)
            }
        }

        composable("info") {
            MainScaffoldLayout(
                titleFactory = { "Info" },
                navController = navHostController
            ) {
                Info(navHostController)
            }
        }
    }
}
