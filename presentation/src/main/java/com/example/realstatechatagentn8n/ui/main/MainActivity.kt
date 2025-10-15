package com.example.realstatechatagentn8n.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.rememberNavController
import com.example.domain.util.NetworkMonitor
import com.example.realstatechatagentn8n.ui.theme.AppTheme
import com.example.realstatechatagentn8n.ui.widget.NoInternetConnectionBanner
import com.example.realstatechatagentn8n.util.setupSystemBarDecoration
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var networkMonitor: NetworkMonitor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.setupSystemBarDecoration()

        setContent {
            val navController = rememberNavController()
            AppTheme {
                Column {
                    val networkStatus by networkMonitor.networkState.collectAsState(null)

                    networkStatus?.let {
                        if (it.isOnline.not()) {
                            NoInternetConnectionBanner()
                        }
                    }
                    MainGraph(
                        mainNavController = navController,
                    )
                }
            }
        }
    }

}