package com.example.retrofitmvvmhilt.api

import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface MyInterface {
@GET("movielist.json")
 fun getMovie(): Flow<Movie>
}