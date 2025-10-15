package com.example.realstatechatagentn8n.ui.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.realstatechatagentn8n.R

@Composable
fun UserMessageItem(message: String, avatarResId: Int = R.drawable.sender_avatar) {

    ConstraintLayout(modifier = Modifier
        .fillMaxWidth().padding(16.dp) ) {

        val (avatar, box , spacer) = createRefs()

        Spacer(modifier = Modifier.height(10.dp).constrainAs (spacer) {
            top.linkTo(parent.top)
        })

        Box(
            modifier = Modifier.constrainAs(box) {
                end.linkTo(parent.end, margin = 10.dp)
                top.linkTo(spacer.bottom)
                horizontalBias = 1.0f
            }
                .widthIn(max = 280.dp)
                .wrapContentHeight()
                .clip(RoundedCornerShape(16.dp))
                .background(Color(0xFF7E8B9F))
                .padding(end = 30.dp ,top =  12.dp, bottom = 12.dp, start = 12.dp)
        ) {
            Text(
                text = message,
                color = Color.White,
                fontSize = 16.sp
            )
        }

        AvatarCard(modifier = Modifier.constrainAs(avatar) {
            end.linkTo(box.end , margin = -15.dp)
            top.linkTo(box.top, margin = -20.dp)
        }, avatarResId = avatarResId)
    }

}
