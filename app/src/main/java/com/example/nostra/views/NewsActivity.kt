package com.example.nostra.views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.view.menu.MenuView
import com.example.nostra.R
import com.example.nostra.models.News
import com.example.nostra.models.Source
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_news.*
import kotlinx.android.synthetic.main.news_item.view.*

class NewsActivity : AppCompatActivity() {

    private var name = ""
    private var author= ""
    private var title = ""
    private var desc = ""
    private var url = ""
    private var urlToImage = ""
    private var publishedAt = ""
    private var content = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        name = intent.getStringExtra("name")
        author= intent.getStringExtra("author")
        title = intent.getStringExtra("title")
        desc = intent.getStringExtra("desc")
        urlToImage = intent.getStringExtra("urlToImage")
        publishedAt = intent.getStringExtra("publishedAt")
        content = intent.getStringExtra("content")
        init()
    }

    fun init(){
        newsDetailName.text=name
        newsDetailAuthor.text = author
        newsDetailTitle.text = title
        newsDetailDesc.text = desc
        newsDetailPublishedAt.text = publishedAt
        newsDetailContent.text = content
        urlToImage.let { Picasso.get().load(it).into(newsDetailImage) }
    }
}
