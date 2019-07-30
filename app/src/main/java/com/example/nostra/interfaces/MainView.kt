package com.example.nostra.interfaces

import com.example.nostra.models.Country
import com.example.nostra.models.News

interface MainView {
    fun showData(data : MutableList<News>)
    fun addSpinner(data : MutableList<Country>)
}