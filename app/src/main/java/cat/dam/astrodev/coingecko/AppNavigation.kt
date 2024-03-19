package cat.dam.astrodev.coingecko

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import cat.dam.astrodev.coingecko.layouts.MainScaffoldLayout
import cat.dam.astrodev.coingecko.screens.Home

@Composable
fun AppNavigation(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = "home") {
        composable("home") {
            MainScaffoldLayout(titleFactory = {
                "Home"
            }) {
                Home(navHostController)
            }
        }
    }
}