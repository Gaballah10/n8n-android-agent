package com.example.realstatechatagentn8n.ui.main

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.realstatechatagentn8n.navigation.Graph
import com.example.realstatechatagentn8n.navigation.Page
import com.example.realstatechatagentn8n.ui.chat.screen.ChatPage
import com.example.realstatechatagentn8n.ui.chat.viewmodel.ChatViewmodel
import com.example.realstatechatagentn8n.util.composableHorizontalSlide


@Composable
fun MainGraph(
    mainNavController: NavHostController,
) {
    NavHost(
        navController = mainNavController,
        startDestination = Page.Chat,
        route = Graph.Main::class
    ) {

        composableHorizontalSlide<Page.Chat> {
            val viewModel = hiltViewModel<ChatViewmodel>()
            ChatPage(
                viewModel = viewModel,
            )
        }

    }
}