package com.example.realstatechatagentn8n.util.preview

import androidx.compose.runtime.Composable
import com.example.realstatechatagentn8n.ui.theme.AppTheme

@Composable
fun PreviewContainer(
    content: @Composable () -> Unit
) {
    AppTheme {
        content()
    }
}