package com.example.realstatechatagentn8n.ui.chat.viewmodel

import android.util.Log
import com.example.domain.entities.ChatRequest
import com.example.domain.repository.DataSourceRepo
import com.example.domain.util.onError
import com.example.domain.util.onSuccess
import com.example.realstatechatagentn8n.entities.MessageItem
import com.example.realstatechatagentn8n.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ChatViewmodel @Inject constructor(
    private val dataSourceRepo: DataSourceRepo.Remote
) : BaseViewModel() {


    private val TAG = "ChatViewModelTag"

    private val _messages = MutableStateFlow<List<MessageItem>>(emptyList())
    val messages: StateFlow<List<MessageItem>> = _messages.asStateFlow()


    private val _showWelcomeMessage = MutableStateFlow(true)
    val showWelcomeMessage = _showWelcomeMessage.asStateFlow()

    fun sendChatMsg(request: ChatRequest) {
        //if (_uiState.value is ChatUiState.Loading) return

        launch {
            //  _uiState.value = ChatUiState.Loading
            dataSourceRepo.sendChatMessage(request)
                .onSuccess { response ->
                    //  _uiState.value = ChatUiState.Success(response)

                    updateLastMessageText(response[0].output!!)
                    hideWelcomeMessage()
                }
                .onError { error ->
                    Log.d(TAG, error.message ?: "Failed to send")
                    // _uiState.value = ChatUiState.Error(error.message ?: "Failed to send")
                }
        }
    }

    fun addMessage(message: MessageItem) {
        _messages.value = _messages.value + message
    }


    private fun updateLastMessageText(newText: String) {
        val current = _messages.value
        if (current.isEmpty()) return

        val updated = current.toMutableList().apply {
            this[lastIndex] = this[lastIndex].copy(text = newText)
        }
        _messages.value = updated.toList()
    }

    fun hideWelcomeMessage() {
        _showWelcomeMessage.value = false
    }

}

