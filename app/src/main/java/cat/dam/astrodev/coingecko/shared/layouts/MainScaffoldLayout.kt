package cat.dam.astrodev.coingecko.shared.layouts

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import cat.dam.astrodev.coingecko.shared.composables.BottomNavigationBar
import cat.dam.astrodev.coingecko.shared.composables.BottomNavigationItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScaffoldLayout(titleFactory: () -> String, navController: NavController, content: @Composable () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        text = titleFactory(),
                        style = MaterialTheme.typography.headlineMedium
                    )
                })
        },
        bottomBar = {
            BottomNavigationBar(
                homeClick = {
                    navController.navigate("home")
                },
                listClick = {
                    navController.navigate("coinList")
                },
                infoClick = {
                    navController.navigate("info")
                },
            )
        }
    ) {
        Surface(modifier = Modifier.padding(it)) {
            content()
        }
    }
}