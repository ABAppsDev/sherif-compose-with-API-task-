package com.route.compose_with_api.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.route.compose_with_api.data.RetrofitInstance
import com.route.compose_with_api.data.model.CatRespose
import com.route.compose_with_api.data.model.Google
import com.route.compose_with_api.data.model.Name
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val api = RetrofitInstance.api
    //val _Posts = MutableLiveData<List<PostResponse>>()
    var catsList : List<CatRespose> by mutableStateOf(listOf())
    fun getCatData() {
        Log.d("getPosts","out of scope")
        viewModelScope.launch {
            try {
                val response = api.getCatData()
                if(response.isNotEmpty()){
                    catsList = response
                    Log.d("getPosts","$catsList")
                }
            }catch (e : Exception){
                val cat = CatRespose(
                    1 ," " ," ",true ," " , Google(" "," "," ")," ",
                    true , Name("first", "last" ),"6666", "http://placehold.it/120×120&text=image1", " "
                )
                catsList = listOf(cat)
            }
        }
    }
}