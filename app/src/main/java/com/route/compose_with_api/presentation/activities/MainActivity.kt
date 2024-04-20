package com.route.compose_with_api.presentation.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.route.compose_with_api.data.model.PostResponse
import com.route.compose_with_api.presentation.PostItem
import com.route.compose_with_api.presentation.viewmodel.MainViewModel
import com.route.compose_with_api.ui.theme.Compose_with_ApiTheme

class MainActivity : ComponentActivity() {
    private val postViewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_with_ApiTheme {
                PostsList(postsList = postViewModel.posts)
                postViewModel.getPosts()
            }
        }
    }
}

@Composable
fun PostsList(postsList : List<PostResponse>){
    LazyColumn {
        itemsIndexed(items = postsList){ index, item ->
            PostItem(item)
        }
    }
}

@Preview(showBackground = true , showSystemUi = true)
@Composable
fun DefaultPreview(){
    val post = PostResponse(
        "ssss",1,"sddsdsd",2
    )
    PostItem(post = post)
}