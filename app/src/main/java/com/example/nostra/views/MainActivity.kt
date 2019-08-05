package com.example.nostra.views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Gravity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.nostra.R
import com.example.nostra.interfaces.MainView
import com.example.nostra.adapters.RecyclerViewAdapter
import com.example.nostra.models.Country
import com.example.nostra.models.News
import com.example.nostra.presenters.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity(),MainView {
    override fun retry() {

        retryBtn.visibility=View.VISIBLE;
    }

    override fun addSpinner(data: MutableList<Country>) {
        val spinner = countrySpinner

        val countries : MutableList<String> = mutableListOf()
        for(country in data){
            countries.add(country.name)
        }

        spinner.onItemSelectedListener = object:AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                country = data[position].code
                loading.visibility=View.VISIBLE
                presenter!!.getData(country)

            }
        }


        val aa = ArrayAdapter(this,android.R.layout.simple_spinner_item,countries)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner!!.adapter = aa

    }

    override fun showData(datas: MutableList<News>?) {
        news.clear()
        if (datas != null) {
            for (data in datas){
                news.add(data)
            }
        }
        recyclerNews.adapter?.notifyDataSetChanged()
        recyclerNews.visibility=View.VISIBLE
        loading.visibility=View.INVISIBLE
    }



    companion object{var news: MutableList<News> = mutableListOf()}
    private var country : String = ""
    private var presenter : MainPresenter? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MainPresenter(this)
        recyclerNews.layoutManager = LinearLayoutManager(this)
        recyclerNews.adapter = RecyclerViewAdapter(this,news){
            startActivity<NewsActivity>(
                "name" to (it.source.name ?: ""),
                "author" to (it.author ?: ""),
                "title" to (it.title ?: ""),
                "desc" to (it.desc ?: ""),
                "urlToImage" to (it.urlToImage ?: ""),
                "publishedAt" to (it.publishedAt ?: ""),
                "content" to (it.content ?: "")
            )
        }
        loading.visibility=View.VISIBLE
        presenter!!.getData(country)
        presenter!!.addSpinner()
        retryBtn.onClick {
            retryBtn.visibility=View.INVISIBLE
            recyclerNews.visibility=View.INVISIBLE
            presenter!!.getData(country)
        }
    }

}
