package com.example.nostra.repositories

import android.app.Service
import com.example.nostra.interfaces.Services
import com.example.nostra.models.ApiResponse
import com.example.nostra.models.News
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiRepository {

    val BASE_URL = "https://newsapi.org"
    val API_KEY = "878748eeb067468096122748e2a7f83b"
    private var retrofit :  Retrofit ? = null
    val repositoryInstance : Retrofit? get(){
        if(retrofit == null){
            retrofit = retrofit2.Retrofit
                .Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit
    }

}