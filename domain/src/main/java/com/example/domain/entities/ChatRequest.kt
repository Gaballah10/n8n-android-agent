package com.example.domain.entities

data class ChatRequest(
    var message: String,
    var sessionId: String = "user1234",
)


