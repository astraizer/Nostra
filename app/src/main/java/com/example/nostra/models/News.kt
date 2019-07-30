package com.example.nostra.models

import com.google.gson.annotations.SerializedName

data class News(
    @SerializedName("source")
    val source: Source,
    @SerializedName("author")
    val author:String?,
    @SerializedName("title")
    val title:String?,
    @SerializedName("description")
    val desc:String?,
    @SerializedName("url")
    val url:String?,
    @SerializedName("urlToImage")
    val urlToImage:String?,
    @SerializedName("publishedAt")
    val publishedAt: String?,
    @SerializedName("content")
    val content:String?)