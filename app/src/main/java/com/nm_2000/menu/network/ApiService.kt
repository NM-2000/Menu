package com.nm_2000.menu.network

import com.nm_2000.menu.model.ApiResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    @GET(".")
    suspend fun getApiResponse(): ApiResponse

    companion object {
        var apiService: ApiService? = null
        fun getInstance(): ApiService {
            if (apiService == null) {
                val interceptor = HttpLoggingInterceptor()
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
                val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
                apiService = Retrofit.Builder()
                    .baseUrl("https://run.mocky.io/v3/b6a30bb0-140f-4966-8608-1dc35fa1fadc/")
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiService::class.java)
            }
            return apiService!!
        }
    }
}