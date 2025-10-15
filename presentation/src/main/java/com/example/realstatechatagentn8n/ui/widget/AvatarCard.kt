package com.example.realstatechatagentn8n.ui.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun AvatarCard(
    modifier: Modifier,
    avatarResId: Int,
    cardSize: Dp = 44.dp,
    strokeWidth: Dp = 4.dp,
    cardCornerRadius: Dp = 18.dp
) {
    Box(
        modifier
            .size(cardSize)
            .clip(RoundedCornerShape(cardCornerRadius))
            .border(
                width = strokeWidth,
                color = Color.White,
                shape = RoundedCornerShape(cardCornerRadius)
            ),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = avatarResId),
            contentDescription = "Avatar",
            modifier = Modifier
                .size(cardSize - strokeWidth * 2),
            contentScale = ContentScale.Crop
        )
    }
}