package cat.dam.astrodev.coingecko.shared.composables

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun AnimationItem(
    animationResId: Int, modifier: Modifier = Modifier
        .fillMaxSize()
        .aspectRatio(1f), callback: suspend () -> Unit
) {
    val composition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(
            animationResId
        )
    )

    LaunchedEffect(true) {
        callback()
    }

    LottieAnimation(
        composition = composition,
        modifier = modifier,
        speed = 1f,
        iterations = LottieConstants.IterateForever
    )
}