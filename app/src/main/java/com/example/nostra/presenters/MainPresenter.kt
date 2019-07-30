package com.example.nostra.presenters

import android.util.Log
import android.widget.Toast
import com.example.nostra.interfaces.MainView
import com.example.nostra.interfaces.Services
import com.example.nostra.models.Article
import com.example.nostra.models.Country
import com.example.nostra.models.News
import com.example.nostra.repositories.ApiRepository
import com.example.nostra.views.MainActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter (_view : MainView) {

    private var view = _view;

    fun getData(country: String){
        var newsList : MutableList<News> = mutableListOf()

        val services = ApiRepository.repositoryInstance?.create(Services::class.java)
        val call = services?.getArticle("top-headlines","technology",country,ApiRepository.API_KEY)
        call?.enqueue(object : Callback<Article> {
            override fun onFailure(call: Call<Article>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<Article>, response: Response<Article>) {
                val body = response.body()
                val articles =  body?.articles
                if (articles != null) {
                    for(news in articles) {
                        newsList.add(news)
                    }
                    view.showData(newsList)
                }
            }
        })
    }

    fun addSpinner(){
        val countries : MutableList<Country> = mutableListOf();
        countries.add(Country("All",""))
        countries.add(Country("Afghanistan","af"))
        countries.add(Country("United Arab Emirates","ar"))
        countries.add(Country("Austria","at"))
        countries.add(Country("Australia","au"))
        countries.add(Country("Belgium","be"))
        countries.add(Country("Bulgaria","bg"))
        countries.add(Country("Brazil","br"))
        countries.add(Country("Canada","ca"))
        countries.add(Country("Switzerland","ch"))
        countries.add(Country("China","cn"))
        countries.add(Country("Colombia","co"))
        countries.add(Country("Cuba","cu"))
        countries.add(Country("Czech Republic","cz"))
        countries.add(Country("Germany","de"))
        countries.add(Country("Egypt","eg"))
        countries.add(Country("France","fr"))
        countries.add(Country("Indonesia","id"))
        view.addSpinner(countries)

    }

}