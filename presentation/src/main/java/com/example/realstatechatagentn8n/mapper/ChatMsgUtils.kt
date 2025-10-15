package com.example.realstatechatagentn8n.mapper

import com.example.domain.entities.ChatRequest
import com.example.domain.entities.ChatResponse
import com.example.realstatechatagentn8n.entities.MessageItem
import com.example.realstatechatagentn8n.util.KeywordsUtility

fun ChatRequest.toMessageItem(): MessageItem {
    return MessageItem(
        text = message,
        messageSender = KeywordsUtility.USER_MESSAGE_ITEM,
        timestamp = System.currentTimeMillis()
    )
}

fun ChatResponse.toMessageItem(): MessageItem {
    return MessageItem(
        text = output.toString(),
        messageSender = KeywordsUtility.AGENT_MESSAGE_ITEM,
        timestamp = System.currentTimeMillis()
    )
}
