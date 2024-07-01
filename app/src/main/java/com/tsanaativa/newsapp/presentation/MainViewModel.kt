package com.tsanaativa.newsapp.presentation

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.models.Article
import com.tsanaativa.newsapp.network.RetrofitClient
import kotlinx.coroutines.launch

enum class STATE {
    LOADING,
    SUCCESS,
    FAILED
}

class MainViewModel : ViewModel() {
    var headlinesResponse : List<Article> by mutableStateOf(listOf())
    var articlesResponse : List<Article> by mutableStateOf(listOf())
    var currentPage:Long by mutableStateOf(1.toLong())
    private var errorMessage: String by mutableStateOf("")

    var headlineState by mutableStateOf(STATE.LOADING)
    var state by mutableStateOf(STATE.LOADING)

    fun getHeadlines() {
        viewModelScope.launch {
            headlineState = STATE.LOADING
            val apiService = RetrofitClient.getInstance()
            try {
                val apiResponse = apiService.getTopHeadlines()
                headlinesResponse = apiResponse.articles
                headlineState = STATE.SUCCESS
            } catch (e: Exception) {
                errorMessage = e.message.toString()
                headlineState = STATE.FAILED
            }
        }
    }

    fun getArticles() {
        viewModelScope.launch {
            state = STATE.LOADING
            val apiService = RetrofitClient.getInstance()
            try {
                val apiResponse = apiService.getArticles(page = currentPage)
                articlesResponse = apiResponse.articles
                currentPage += 1
                state = STATE.SUCCESS
            } catch (e: Exception) {
                errorMessage = e.message.toString()
                state = STATE.FAILED
            }
        }
    }

    fun loadMoreArticles() {
        state = STATE.LOADING
        viewModelScope.launch {
            val apiService = RetrofitClient.getInstance()
            try {
                val apiResponse = apiService.getArticles(page = currentPage)
                articlesResponse = articlesResponse.plus(apiResponse.articles)
                currentPage += 1
                state = STATE.SUCCESS
            } catch (e: Exception) {
                errorMessage = e.message.toString()
                state = STATE.FAILED
            }
        }
    }
}










