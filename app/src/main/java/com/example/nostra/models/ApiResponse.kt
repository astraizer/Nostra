package com.example.nostra.models

import com.google.gson.annotations.SerializedName

class ApiResponse {
    @SerializedName("articles")
    var articles : MutableList<News> = mutableListOf()

    fun getResults():MutableList<News>{
        return articles
    }

    fun setResults(articles : MutableList<News>){
        this.articles =  articles
    }
}