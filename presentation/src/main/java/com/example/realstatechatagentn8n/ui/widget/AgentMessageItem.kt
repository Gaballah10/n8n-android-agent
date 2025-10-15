package com.example.realstatechatagentn8n.ui.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.realstatechatagentn8n.R

@Composable
fun AgentMessageItem(message: String) {

    ConstraintLayout(modifier = Modifier
        .fillMaxWidth().padding(16.dp) ) {

        val (avatar, box , spacer) = createRefs()

        Spacer(modifier = Modifier.height(10.dp).constrainAs (spacer) {
            top.linkTo(parent.top)
        })

        Box(
            modifier = Modifier.constrainAs(box) {
                start.linkTo(parent.start, margin = 10.dp)
                top.linkTo(spacer.bottom)
                horizontalBias = 1.0f
            }
                .widthIn(max = 280.dp)
                .wrapContentHeight()
                .clip(RoundedCornerShape(16.dp))
                .background(Color(0xFF5773FF))
                .padding(start = 30.dp ,top =  12.dp, bottom = 12.dp, end = 12.dp)
        ) {

            if (!message.isEmpty()){
                Text(
                    text = message,
                    color = Color.White,
                    fontSize = 16.sp
                )
            }else {
                DynamicShimmeringText("Agent is thinking ...")
            }



        }

        AgentAvatarCard(lottieResId=R.raw.ai_logo_answer, modifier = Modifier.constrainAs(avatar) {
            start.linkTo(box.start , margin = -15.dp)
            top.linkTo(box.top, margin = -20.dp)
        })
    }

}