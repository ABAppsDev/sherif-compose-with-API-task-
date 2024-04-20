package com.route.compose_with_api.presentation.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.route.compose_with_api.data.model.CatRespose
import com.route.compose_with_api.data.model.Google
import com.route.compose_with_api.data.model.Name
import com.route.compose_with_api.presentation.CatItem
import com.route.compose_with_api.presentation.viewmodel.MainViewModel
import com.route.compose_with_api.ui.theme.Compose_with_ApiTheme

class MainActivity : ComponentActivity() {
    private val catsViewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_with_ApiTheme {
                CatsList(catsViewModel.catsList)
                catsViewModel.getCatData()
                Log.d("getPosts","in setContent")
            }
        }
    }
}

@Composable
fun CatsList(catList : List<CatRespose>){
    LazyColumn {
        itemsIndexed(items = catList){ index, item ->
            CatItem(item)
        }
    }
}

@Preview(showBackground = true , showSystemUi = true)
@Composable
fun DefaultPreview(){
    val cat = CatRespose(
      1 ," " ," ",true ," " , Google(" "," "," ")," ",
        true , Name("first", "last" ),"6666", "http://placehold.it/120×120&text=image1", " "
    )
    CatItem(cat = cat)
}