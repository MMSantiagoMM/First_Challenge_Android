package com.example.imdb2.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imdb2.core.Constant
import com.example.imdb2.models.MovieModel
import com.example.imdb2.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieViewModel:ViewModel() {
    private var _listMovies = MutableLiveData<List<MovieModel>>()
    val listMovies: LiveData<List<MovieModel>> = _listMovies

    fun getPoster(){
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitClient.iwebService.getPoster(Constant.API_KEY)
            withContext(Dispatchers.Main){
                _listMovies.value = response.body()!!.results.sortedByDescending { it.voteAverage }
            }
        }
    }

    fun getPopular(){
        viewModelScope.launch (Dispatchers.IO){
            val response = RetrofitClient.iwebService.getPopular(Constant.API_KEY)
            withContext(Dispatchers.Main){
                _listMovies.value = response.body()!!.results.sortedByDescending { it.voteAverage }
            }
        }
    }

}