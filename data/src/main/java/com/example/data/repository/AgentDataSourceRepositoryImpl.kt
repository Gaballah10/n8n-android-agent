package com.example.data.repository

import com.example.data.api.AgentApi
import com.example.domain.entities.ChatRequest
import com.example.domain.entities.ChatResponse
import com.example.domain.util.Result
import javax.inject.Inject

class AgentDataSourceRepositoryImpl @Inject constructor(
    private val agentApi: AgentApi
) : AgentDataSourceRepository.Remote {


    override suspend fun sendChatMessage(request: ChatRequest): Result<List<ChatResponse>> {
        return try {
            val response = agentApi.sendChatMessage(request)
            Result.Success(response)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }


}