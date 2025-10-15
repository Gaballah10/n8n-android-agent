package com.example.domain.repository

import com.example.domain.entities.ChatRequest
import com.example.domain.entities.ChatResponse
import com.example.domain.util.Result

interface DataSourceRepo {

    interface Remote {
        suspend fun sendChatMessage(request: ChatRequest): Result<List<ChatResponse>>
    }
}