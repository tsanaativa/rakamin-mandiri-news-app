package com.tsanaativa.newsapp.network

import com.tsanaativa.newsapp.constants.Constant
import com.tsanaativa.newsapp.interfaces.IApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {
        private var apiService: IApiService?= null
        fun getInstance(): IApiService {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl(Constant.BASE_URL)
                    .addConverterFactory((GsonConverterFactory.create()))
                    .build()
                    .create(IApiService::class.java)
            }
            return apiService!!
        }
    }
}