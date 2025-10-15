package com.example.realstatechatagentn8n.ui.chat.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.domain.entities.ChatRequest
import com.example.domain.entities.ChatResponse
import com.example.mygithubusersapplications.ui.theme.AppColor.StatusGrey
import com.example.realstatechatagentn8n.R
import com.example.realstatechatagentn8n.entities.MessageItem
import com.example.realstatechatagentn8n.mapper.toMessageItem
import com.example.realstatechatagentn8n.ui.chat.viewmodel.ChatViewmodel
import com.example.realstatechatagentn8n.ui.widget.AgentMessageItem
import com.example.realstatechatagentn8n.ui.widget.ChatInputBar
import com.example.realstatechatagentn8n.ui.widget.UserMessageItem
import com.example.realstatechatagentn8n.ui.widget.WelcomeMessage
import com.example.realstatechatagentn8n.util.KeywordsUtility

@Composable
fun ChatPage(
    viewModel: ChatViewmodel,
) {

    val messages by viewModel.messages.collectAsState()
    val showWelcome by viewModel.showWelcomeMessage.collectAsStateWithLifecycle()

    val listState = rememberLazyListState()

    LaunchedEffect(messages.size) {
        if (messages.isNotEmpty()) {
            listState.animateScrollToItem(messages.lastIndex)
        }
    }

    ChatScreen(messages, showWelcome, viewModel, listState)
}

@Composable
fun ChatScreen(
    messages: List<MessageItem>,
    showWelcome: Boolean,
    viewModel: ChatViewmodel,
    listState: LazyListState
) {


    Scaffold(
        containerColor = StatusGrey,
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .fillMaxSize()
                    .padding(top = 20.dp)
            ) {

                AnimatedVisibility(
                    visible = showWelcome,
                    enter = fadeIn(
                        initialAlpha = 0.0f,
                        animationSpec = tween(5000)
                    ) + expandHorizontally(),
                    exit = fadeOut(animationSpec = tween(1000)) + shrinkVertically()
                ) {
                    WelcomeMessage(
                        modifier = Modifier.fillMaxWidth(),
                        text = stringResource(R.string.welcome_msg),
                        lottieResId = R.raw.ai_logo_answer
                    )
                }

                LazyColumn(
                    state = listState,
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),

                    reverseLayout = false,
                    verticalArrangement = Arrangement.Top
                ) {


                    items(
                        count = messages.size,
                        key = { index -> messages[index].id }
                    ) { index ->
                        val message = messages[index]
                        AnimatedVisibility(
                            visible = true,
                            enter = fadeIn() + expandVertically(),
                            exit = fadeOut() + shrinkVertically()
                        ) {
                            when (message.messageSender) {
                                KeywordsUtility.AGENT_MESSAGE_ITEM -> {
                                    AgentMessageItem(message.text)
                                }

                                KeywordsUtility.USER_MESSAGE_ITEM -> {
                                    UserMessageItem(message.text)
                                }

                                else -> {}
                            }
                        }
                    }
                }

                ChatInputBar(
                    onSendMessage = { message ->
                        sendMsg(viewModel, message)
                    }
                )
            }
        }
    )
}

private fun sendMsg(viewModel: ChatViewmodel, message: String) {
    var requestMsg = ChatRequest(
        message = message
    )
    var thinkingMsg = ChatResponse(output = "").toMessageItem()
    viewModel.addMessage(requestMsg.toMessageItem())
    viewModel.addMessage(thinkingMsg)
    viewModel.sendChatMsg(requestMsg)
}

