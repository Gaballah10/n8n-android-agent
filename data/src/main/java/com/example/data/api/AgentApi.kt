package com.example.data.api

import com.example.domain.entities.ChatRequest
import com.example.domain.entities.ChatResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AgentApi {

    @POST("webhook/chat")
    suspend fun sendChatMessage(
        @Body request: ChatRequest
    ): List<ChatResponse>

}
