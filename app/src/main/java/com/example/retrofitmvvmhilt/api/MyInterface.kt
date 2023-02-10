package com.example.retrofitmvvmhilt.api

import retrofit2.http.GET

interface MyInterface {
@GET("movielist.json")
suspend fun getMovie():List<Movie>
}