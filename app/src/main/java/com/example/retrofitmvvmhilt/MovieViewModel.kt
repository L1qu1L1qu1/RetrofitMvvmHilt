package com.example.retrofitmvvmhilt

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitmvvmhilt.api.Movie
import com.example.retrofitmvvmhilt.api.MyInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class MovieViewModel @Inject constructor(var myInterface: MyInterface): ViewModel() {
    var mutableStateListOf = mutableStateListOf<Movie>()

    fun getMovies(){
        viewModelScope
            .launch(IO){


              mutableStateListOf.addAll(myInterface.getMovie())


        }
    }
}