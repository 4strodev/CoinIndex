package cat.dam.astrodev.coingecko.shared.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import cat.dam.astrodev.coingecko.R

@Composable
fun BottomNavigationBar(
    homeClick: () -> Unit,
    listClick: () -> Unit,
    infoClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val barViewModel = BottomVarViewModel.instance
    val selected = barViewModel.selectedPage

    BottomAppBar {
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            val homeIconPainter =
                if (selected == BottomNavigationItem.HOME) painterResource(id = R.drawable.home_filled)
                else painterResource(id = R.drawable.home)
            IconButton(onClick = {
                barViewModel.selectedPage = BottomNavigationItem.HOME
                homeClick()
            }) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        painter = homeIconPainter,
                        contentDescription = stringResource(id = R.string.txt_home_icon_description),
                        modifier = Modifier.size(25.dp)
                    )
                }
            }
            val listIconPainter =
                if (selected == BottomNavigationItem.LIST) painterResource(id = R.drawable.list_filled)
                else painterResource(id = R.drawable.list)
            IconButton(onClick = {
                barViewModel.selectedPage = BottomNavigationItem.LIST
                listClick()
            }) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        painter = listIconPainter,
                        contentDescription = stringResource(id = R.string.txt_list_icon_description),
                        modifier = Modifier.size(25.dp)
                    )
                }
            }
            val infoIconPainter =
                if (selected == BottomNavigationItem.INFO) painterResource(id = R.drawable.info_filled)
                else painterResource(id = R.drawable.info)
            IconButton(onClick = {
                barViewModel.selectedPage = BottomNavigationItem.INFO
                infoClick()
            }) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        painter = infoIconPainter,
                        contentDescription = stringResource(id = R.string.txt_info_icon_description),
                        modifier = Modifier.size(25.dp)
                    )
                }
            }
        }
    }
}

enum class BottomNavigationItem {
    HOME, LIST, INFO
}