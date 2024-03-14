package com.example.supabasetest.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.supabasetest.Common.News
import com.example.supabasetest.Common.User
import com.example.supabasetest.Model.Supabase

class BaseViewModel():ViewModel() {
    private val repository: Supabase = Supabase()
    val news = MutableLiveData<List<News>>()
    val users = MutableLiveData<List<User>>()
    val user = MutableLiveData<User>()

    suspend fun getNews(callback:(List<News>)->Unit){
        repository.getNews(){
            news.postValue(it)
        }
    }

    suspend fun getUsers(callback:(List<User>)->Unit){
        repository.getUsers(){
            users.postValue(it)
        }
    }

    suspend fun getUser(id:Int,callback: (User) -> Unit){
        repository.getUser(id){
            user.postValue(it)
        }
    }
}