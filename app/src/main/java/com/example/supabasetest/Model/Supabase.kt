package com.example.supabasetest.Model

import com.example.supabasetest.Common.News
import com.example.supabasetest.Common.User
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.Auth
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.postgrest.postgrest

class Supabase {
     private val supabaseClient = createSupabaseClient(
        supabaseUrl = "https://mmviqimgexkjdvmlasua.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Im1tdmlxaW1nZXhramR2bWxhc3VhIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MTAyNjM3OTEsImV4cCI6MjAyNTgzOTc5MX0.UTttVYVHIdYfN9J1ta-WJ3gl8uCz-rYGwdLKxl20vY8"
    ) {
        install(Postgrest)
    }

    suspend fun getUsers(): List<User> {
        return supabaseClient.postgrest["Users"].select().decodeList<User>()
    }

    suspend fun getUser(id:Int): User {
        val user:User = supabaseClient.postgrest["Users"].select{
            filter {
                eq("id",id)
            }
        }.decodeSingle<User>()
        return user
    }

    suspend fun getNews():List<News>{
        val news = supabaseClient.postgrest["News"].select().decodeList<News>()
        return news
    }
}