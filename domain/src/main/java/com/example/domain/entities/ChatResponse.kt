package com.example.domain.entities

import com.google.gson.annotations.SerializedName

data class ChatResponse(
    @SerializedName("output") var output : String? = null
)
