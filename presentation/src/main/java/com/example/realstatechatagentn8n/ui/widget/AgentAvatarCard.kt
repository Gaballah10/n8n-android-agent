package com.example.realstatechatagentn8n.ui.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun AgentAvatarCard(
    modifier: Modifier = Modifier,
    lottieResId: Int,
    cardSize: Dp = 44.dp,
    strokeWidth: Dp = 4.dp,
    cardCornerRadius: Dp = 18.dp
) {
    val composition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(lottieResId)
    )

    Box(
        modifier = modifier
            .size(cardSize)
            .clip(RoundedCornerShape(cardCornerRadius))
            .border(
                width = strokeWidth,
                color = Color.White,
                shape = RoundedCornerShape(cardCornerRadius)
            ),
        contentAlignment = Alignment.Center
    ) {
        LottieAnimation(
            composition = composition,
            modifier = Modifier.size(cardSize - strokeWidth * 1) .background(Color(0xffffffff)),
            isPlaying = true,
            iterations = LottieConstants.IterateForever,
        )
    }
}