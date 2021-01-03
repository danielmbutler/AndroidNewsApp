package com.example.newsapp


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.newsapp.models.NewsPost
import kotlinx.android.synthetic.main.layout_news_list_item.view.*
import org.json.JSONObject

class NewsRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var items: List<NewsPost> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return NewsPostViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_news_list_item, parent, false)
        )

    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is NewsPostViewHolder -> {
                holder.bind(items.get(position))
            }
        }
    }

    fun submitList(NewsPostList: List<NewsPost>){
        items = NewsPostList
    }

    class NewsPostViewHolder constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView){

        val NewsPost_Title      =   itemView.blog_title
        val NewsPost_Image      =   itemView.blog_image
        val NewsPost_date       =   itemView.blog_date
        val NewsPost_Source     =   itemView.blog_source
        val NewsPost_Author     =   itemView.blog_author

        fun bind(newsPost: NewsPost){

            NewsPost_Title.setText(newsPost.title)
            NewsPost_Author.setText(newsPost.author)
            NewsPost_date.setText(newsPost.date)
            NewsPost_Source.setText(newsPost.source)

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(newsPost.image)
                .into(NewsPost_Image)

        }
    }

}