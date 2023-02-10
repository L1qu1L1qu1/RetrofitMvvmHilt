package com.example.retrofitmvvmhilt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.retrofitmvvmhilt.api.MyInterface
import com.example.retrofitmvvmhilt.ui.theme.RetrofitMvvmHiltTheme
import dagger.hilt.android.AndroidEntryPoint
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.LiveData

import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch



import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var myInterface: MyInterface
    val movieViewModel by viewModels<MovieViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            MyList()
        }
    }
}
@Composable
fun MyList( movieViewModel:MovieViewModel = hiltViewModel()){
//   movieViewModel.getMovies()
//    LazyColumn(){
//        items(movieViewModel.mutableStateListOf){
//            Text(text = it.name)
//        }
//    }
    launch() {
        movieViewModel.getMovies().collect{
            println(it)}
    }








}

