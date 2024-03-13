package com.example.supabasetest.Common

import kotlinx.serialization.Serializable

@Serializable
data class User (
    val id: Int=0,
    val name: String="",
    val lastname: String="",
    val patronymic: String?="",
    val login: String="",
    val password: String="",
    val ismale: Boolean?=true
)