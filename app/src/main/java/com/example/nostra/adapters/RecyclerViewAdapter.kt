package com.example.nostra.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.nostra.R
import com.example.nostra.models.News
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.news_item.view.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class RecyclerViewAdapter(private val context: Context, private val news: MutableList<News>,private val listener: (News) -> Unit) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.news_item,parent,false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(news[position],listener)
    }

    override fun getItemCount() = news.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        fun bindItem(news : News, listener : (News)->Unit){
            itemView.newsTitle.text = news.title
            news.urlToImage.let { Picasso.get().load(it).into(itemView.newsImage) }
            itemView.newsItem.onClick {
                listener(news)
            }
        }

    }
}