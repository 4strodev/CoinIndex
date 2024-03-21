package cat.dam.astrodev.coingecko.features.coins.screens.coinlist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import cat.dam.astrodev.coingecko.features.coins.composables.CoinCard
import cat.dam.astrodev.coingecko.features.coins.screens.coinlist.viewmodels.CoinDetailsViewModel
import cat.dam.astrodev.coingecko.features.coins.screens.coinlist.viewmodels.CoinListViewModel
import kotlinx.coroutines.launch

@Composable
fun CoinList(navController: NavController) {
    val coinListViewModel = CoinListViewModel.instance
    val scope = rememberCoroutineScope()


    SideEffect {
        if (coinListViewModel.coinList.isEmpty() && !coinListViewModel.fetchingData && !coinListViewModel.endReached) {
            scope.launch {
                coinListViewModel.getNextPage()
                println("First coin: ${coinListViewModel.coinList[0].name}")
            }
        }
    }

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(coinListViewModel.coinList.size) { index ->
            val bottomReached = index == coinListViewModel.coinList.size - 1
            if (!coinListViewModel.fetchingData && bottomReached && !coinListViewModel.endReached) {
                SideEffect {
                    scope.launch {
                        coinListViewModel.getNextPage()
                    }
                }
            }
            val coin = coinListViewModel.coinList[index]
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
                    .clickable {
                        CoinDetailsViewModel.instance.id = coin.id
                        // TODO navigate to details
                    }
            ) {
                CoinCard(coin)
            }
        }
        item {
            if (coinListViewModel.fetchingData) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.width(40.dp),
                        color = MaterialTheme.colorScheme.secondary,
                    )
                }
            }
        }
    }

}


@Preview
@Composable
fun CoinListPreview() {
    CoinList(navController = rememberNavController())
}