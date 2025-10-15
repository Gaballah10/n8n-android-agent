package com.example.realstatechatagentn8n.entities

import com.example.realstatechatagentn8n.R
import java.util.UUID

data class MessageItem(
    val id: String = UUID.randomUUID().toString(),
    var text: String,
    val messageSender: String,
    val timestamp: Long,
    val avatarResId: Int = R.drawable.sender_avatar
)
