package com.example.realstatechatagentn8n.ui.widget

import android.graphics.Shader
import androidx.compose.animation.core.DurationBasedAnimationSpec
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.LinearGradientShader
import androidx.compose.ui.graphics.ShaderBrush

@Composable
fun DynamicShimmeringText(
    text: String,
    baseColor: Color = Color.White,
    modifier: Modifier = Modifier,
    textStyle: androidx.compose.ui.text.TextStyle = LocalTextStyle.current
) {
    val shimmerColor = baseColor.brighter()
    ShimmeringText(
        text = text,
        shimmerColor = shimmerColor,
        modifier = modifier,
        textStyle = textStyle
    )
}


@Composable
fun ShimmeringText(
    text: String,
    shimmerColor: Color,
    modifier: Modifier = Modifier,
    textStyle: androidx.compose.ui.text.TextStyle = LocalTextStyle.current,
    animationSpec: DurationBasedAnimationSpec<Float> = tween(1500, 500, LinearEasing)
) {
    val infiniteTransition = rememberInfiniteTransition(label = "ShimmeringTextTransition")

    val shimmerProgress = infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(animationSpec),
        label = "ShimmerProgress"
    )

    val brush = remember(shimmerProgress) {
        object : ShaderBrush() {
            override fun createShader(size: Size): Shader {
                val initialXOffset = -size.width
                val totalSweepDistance = size.width * 2
                val currentPosition = initialXOffset + totalSweepDistance * shimmerProgress.value

                return LinearGradientShader(
                    colors = listOf(Color.Transparent, shimmerColor, Color.Transparent),
                    from = Offset(currentPosition, 0f),
                    to = Offset(currentPosition + size.width, 0f)
                )
            }
        }
    }

    Text(
        text = text,
        modifier = modifier,
        style = textStyle.copy(brush = brush)
    )
}

fun Color.brighter(): Color {
    val blendRatio = 0.3f
    return Color(
        red = (this.red * (1 - blendRatio) + 1f * blendRatio).coerceIn(0f, 1f),
        green = (this.green * (1 - blendRatio) + 1f * blendRatio).coerceIn(0f, 1f),
        blue = (this.blue * (1 - blendRatio) + 1f * blendRatio).coerceIn(0f, 1f),
        alpha = this.alpha
    )
}
