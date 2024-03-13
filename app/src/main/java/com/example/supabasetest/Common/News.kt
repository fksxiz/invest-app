package com.example.supabasetest.Common

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class News(
    val id:Int,
    val title:String,
    val text:String,
    val author:String
)
