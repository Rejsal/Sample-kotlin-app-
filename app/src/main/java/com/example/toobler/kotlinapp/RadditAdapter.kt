package com.example.toobler.kotlinapp

import android.content.Context
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.reddit_item.view.*


/**
 * Created by toobler on 10/9/18.
 */
class RadditAdapter(val data:List<Model.Children>,val context:Context) : RecyclerView.Adapter<RadditViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RadditViewHolder {
        return RadditViewHolder(LayoutInflater.from(context).inflate(R.layout.reddit_item, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RadditViewHolder?, position: Int) {
        val item = data.get(position)
        holder?.redditAuthor?.text = item.data.author
        val thumbnailUri:Uri = Uri.parse(item.data.thumbnail)
        Glide.with(context).load(thumbnailUri).into(holder?.redditImage!!)
        holder?.redditContent?.text = item.data.title
    }

}
class RadditViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val redditImage = itemView.reddit_image
    val redditAuthor = itemView.reddit_author
    val redditContent = itemView.reddit_content

}