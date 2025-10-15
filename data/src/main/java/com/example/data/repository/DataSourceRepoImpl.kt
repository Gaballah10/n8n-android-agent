package com.example.data.repository

import com.example.domain.entities.ChatRequest
import com.example.domain.entities.ChatResponse
import com.example.domain.repository.DataSourceRepo
import com.example.domain.util.Result

class DataSourceRepoImpl(var agentDataSourceRepository : AgentDataSourceRepository.Remote) : DataSourceRepo.Remote {

    override suspend fun sendChatMessage(request: ChatRequest): Result<List<ChatResponse>> {
       return agentDataSourceRepository.sendChatMessage(request)
    }

}