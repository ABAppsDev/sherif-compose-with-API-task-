package com.route.compose_with_api.presentation.viewmodel

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
import kotlinx.coroutines.DEBUG_PROPERTY_NAME
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val api = RetrofitInstance.api
    //val _Posts = MutableLiveData<List<PostResponse>>()
    var posts : List<PostResponse> by mutableStateOf(listOf())
    fun getPosts() {
        viewModelScope.launch {
            try {
                val response = api.getPosts()
                if(response.isNotEmpty()){
                    posts = response
                }
            }catch (e : Exception){

            }
        }
    }
}