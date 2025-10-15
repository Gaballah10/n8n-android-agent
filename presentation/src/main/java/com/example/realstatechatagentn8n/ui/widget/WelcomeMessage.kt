package com.example.realstatechatagentn8n.ui.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun WelcomeMessage(modifier: Modifier,text: String, lottieResId: Int,) {

    val composition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(lottieResId)
    )

    Row(modifier = Modifier.fillMaxWidth().padding(start = 15.dp, end = 15.dp)) {



        Box(
            modifier = Modifier
                .size(44.dp)
                .clip(RoundedCornerShape(18.dp)),
            contentAlignment = Alignment.Center
        ) {
            LottieAnimation(
                composition = composition,
                modifier = Modifier.size(50.dp) .background(Color(0xffffffff)),
                isPlaying = true,
                iterations = LottieConstants.IterateForever,

            )
        }

        Box (Modifier.width(15.dp)) {}

        Text(text, style = TextStyle(fontSize = 14.sp, color = Color.Gray , ))
    }
}