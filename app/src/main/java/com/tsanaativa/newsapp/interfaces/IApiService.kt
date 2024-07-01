package com.tsanaativa.newsapp.interfaces

import com.example.newsapp.models.ArticlesResponse
import com.tsanaativa.newsapp.constants.Constant
import retrofit2.http.GET
import retrofit2.http.Query

interface IApiService {
    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("apiKey") apiKey: String = Constant.API_KEY,
        @Query("sources") country: String = Constant.SOURCES,
        @Query("page") page: Long = 1,
        @Query("pageSize") pageSize: Int = 10
    ): ArticlesResponse
    @GET("everything")
    suspend fun getArticles(
        @Query("apiKey") apiKey: String = Constant.API_KEY,
        @Query("domains") domains: String = Constant.DOMAINS,
        @Query("page") page: Long = 1,
        @Query("pageSize") pageSize: Int = 10
    ): ArticlesResponse
}