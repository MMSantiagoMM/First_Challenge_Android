package com.example.imdb2.network.response

import com.example.imdb2.models.MovieModel
import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("results")


    var results: List<MovieModel>

)
