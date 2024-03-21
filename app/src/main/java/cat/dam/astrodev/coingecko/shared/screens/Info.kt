package cat.dam.astrodev.coingecko.shared.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import cat.dam.astrodev.coingecko.R
import cat.dam.astrodev.coingecko.ui.theme.creditsFont

@Composable
fun Info(navController: NavController) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item() {
            Text(
                stringResource(id = R.string.txt_created_by),
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 15.dp, top = 40.dp),
                fontFamily = creditsFont,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.primary
            )
            Column(modifier = Modifier.fillMaxSize()) {
                Text(
                    stringResource(id = R.string.txt_alejandro_marin),
                    style = MaterialTheme.typography.headlineSmall,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 25.dp),
                    fontFamily = creditsFont,
                    color = MaterialTheme.colorScheme.secondary
                )
                Text(
                    stringResource(id = R.string.txt_about),
                    style = MaterialTheme.typography.headlineLarge,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 15.dp),
                    fontFamily = creditsFont,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.primary
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp)
                ) {
                    Text(
                        stringResource(id = R.string.txt_app_description),
                        style = MaterialTheme.typography.bodyLarge,
                        fontFamily = creditsFont,
                        color = MaterialTheme.colorScheme.secondary,
                        textAlign = TextAlign.Justify
                    )
                }
            }
        }
    }
}