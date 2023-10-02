package com.example.imdb2.network

import com.example.imdb2.network.response.MovieResponse
import retrofit2.Response

import retrofit2.http.GET
import retrofit2.http.Query

interface IWebService {
    @GET("now_playing")
    suspend fun getPoster(
        @Query("api_key") apiKey:String
    ): Response<MovieResponse>

    @GET("popular")
    suspend fun getPopular(
        @Query("api_key") apiKey: String
    ): Response<MovieResponse>
}