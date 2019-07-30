package com.example.nostra.models

import com.google.gson.annotations.SerializedName

data class Article(@SerializedName("articles") var articles : List<News>) {
}