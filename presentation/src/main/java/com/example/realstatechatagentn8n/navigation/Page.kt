package com.example.realstatechatagentn8n.navigation

import kotlinx.serialization.Serializable

sealed class Page {

    @Serializable
    data object Chat : Page()

}

sealed class Graph {
    @Serializable
    data object Main : Graph()
}

fun Page.route(): String? {
    return this.javaClass.canonicalName
}