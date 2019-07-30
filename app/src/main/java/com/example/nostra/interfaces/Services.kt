package com.example.nostra.interfaces

import com.example.nostra.models.Article
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Services {
    @GET("/v2/{type}")
    fun getArticle(@Path("type") type: String, @Query("category") category : String, @Query("country") country:String, @Query("apiKey") apiKey:String):Call<Article>
}