package com.example.mylibrary.data.api

import PhotoApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.getValue

object PhotoApiClient {
    private const val BASE_URL = "https://picsum.photos/v2/"

    val apiService: PhotoApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PhotoApiService::class.java)
    }
}