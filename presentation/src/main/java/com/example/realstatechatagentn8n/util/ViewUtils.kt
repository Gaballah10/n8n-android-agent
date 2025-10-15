package com.example.realstatechatagentn8n.util

import android.app.Activity
import androidx.core.view.WindowCompat

fun Activity.setupSystemBarDecoration(){
    WindowCompat.setDecorFitsSystemWindows(window, true)

    //  val windowInsetsController = WindowInsetsControllerCompat(window, window.decorView)
    //  window.statusBarColor = 0xFF0C0C0C.toInt()
    //  windowInsetsController.isAppearanceLightStatusBars = false
    //  windowInsetsController.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
}