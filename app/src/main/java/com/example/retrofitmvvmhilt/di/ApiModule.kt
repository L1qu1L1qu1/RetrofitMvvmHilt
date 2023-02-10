package com.example.retrofitmvvmhilt.di

import com.example.retrofitmvvmhilt.api.MyInterface
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {
@Provides
fun myInterface():MyInterface{
    var retrofit = Retrofit.Builder()
        .baseUrl("https://howtodoandroid.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    var myInterface:MyInterface=retrofit.create(MyInterface::class.java)
    return myInterface

}
}