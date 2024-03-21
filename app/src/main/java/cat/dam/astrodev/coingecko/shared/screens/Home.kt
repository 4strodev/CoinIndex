package cat.dam.astrodev.coingecko.shared.screens

import android.app.Activity
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.EaseInElastic
import androidx.compose.animation.core.EaseInOutCirc
import androidx.compose.animation.core.EaseOutBounce
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import cat.dam.astrodev.coingecko.AppSurface
import cat.dam.astrodev.coingecko.R
import kotlinx.coroutines.delay
import cat.dam.astrodev.coingecko.ui.theme.appTitleFont

@Composable
fun Home(navController: NavController) {
    val context = LocalContext.current

    var isAnimationFinished by remember { mutableStateOf(false) }

    LaunchedEffect(true) {
        delay(500)
        isAnimationFinished = true
    }

    val scaleValue by animateFloatAsState(
        targetValue = if (isAnimationFinished) 1f else 0.5f,
        animationSpec = tween(
            durationMillis = 1000,
            easing = EaseInElastic
        ),
        label = "Scale animation"
    )

    val rotationValue by animateFloatAsState(
        targetValue = if (isAnimationFinished) 360f else 0f,
        animationSpec = tween(
            durationMillis = 2000
        ),
        label = "Rotation animation"
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        item {
            // App Name
            Text(
                text = stringResource(id = R.string.txt_app_title),
                modifier = Modifier
                    .scale(scaleValue),
                style = MaterialTheme.typography.titleLarge,
                fontFamily = appTitleFont,
                color = MaterialTheme.colorScheme.secondary,
                fontSize = 64.sp
            )

            Spacer(modifier = Modifier.height(20.dp))

            Image(
                painter = painterResource(id = R.drawable.bitcoin),
                contentDescription = null,
                modifier = Modifier
                    .graphicsLayer(rotationZ = rotationValue)
                    .animateContentSize(),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = stringResource(id = R.string.txt_exit),
                modifier = Modifier
                    .clickable {
                        val activity = context as? Activity
                        activity?.finishAffinity()
                    }
                    .background(MaterialTheme.colorScheme.background),
                color = MaterialTheme.colorScheme.onBackground,
                textDecoration = TextDecoration.Underline
            )
        }
    }
}

@Preview
@Composable
fun HomePreview() {
    AppSurface {
        Home(navController = rememberNavController())
    }
}