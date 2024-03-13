package com.example.supabasetest.ViewModel

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.supabasetest.Common.News
import com.example.supabasetest.Common.User
import com.example.supabasetest.R

class ListAdapter(private val context:Context): BaseAdapter(){
    var news: List<News> = emptyList()
    override fun getCount(): Int {
        return news.count()
    }

    override fun getItem(position: Int): Any {
        return news[position]
    }

    override fun getItemId(position: Int): Long {
        return news[position].id.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val item = getItem(position) as News
        var view = convertView?: LayoutInflater.from(context).inflate(R.layout.news_item,parent,false)
        view.apply {
            findViewById<TextView>(R.id.TitleTextView).text = item.title
            findViewById<TextView>(R.id.DescTextView).text = item.text
            findViewById<TextView>(R.id.AuthorTextView).text = item.author
        }
        return view
    }
}