package com.route.compose_with_api.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.route.compose_with_api.data.RetrofitInstance
import com.route.compose_with_api.data.model.PostResponse
import com.route.compose_with_api.domain.usecase.UseCase
import kotlinx.coroutines.DEBUG_PROPERTY_NAME
import kotlinx.coroutines.launch
import retrofit2.await

class MainViewModel : ViewModel() {
   private lateinit var postsUseCase : UseCase
    //private val api = RetrofitInstance.api
    //val _Posts = MutableLiveData<List<PostResponse>>()
    var posts : List<PostResponse> by mutableStateOf(listOf())
    fun getPosts() {
        Log.d("getPosts","outside of scope")
        viewModelScope.launch {
            try {
                val response = postsUseCase.execute().await()
                if(response.isNotEmpty()){
                    posts = response
                    Log.d("getPosts","$posts")
                }
            }catch (e : Exception){
                val postErrorOne = PostResponse("Error when call data " ,0
                    ,"some thing wrong",0)
                posts = listOf(postErrorOne)
                Log.d("getPosts","$posts")
            }
        }
    }
}