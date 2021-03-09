package com.example.newsapp.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.newsapp.R
import com.example.newsapp.models.BreakingNewsItem
import com.example.newsapp.models.Data
import com.example.newsapp.models.NewsPost
import kotlinx.android.synthetic.main.layout_breaking_news_item.view.*
import kotlinx.android.synthetic.main.layout_news_list_item.view.*



class TestAdapter(context: Context, private val datas: List<Data>, private val listener: OnItemClickListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            R.layout.layout_breaking_news_item -> TestBreakingNewsViewHolder(
                inflater.inflate(
                    viewType,
                    parent,
                    false
                )
            )

            R.layout.layout_news_list_item -> TestNewsPostViewHolder(
                inflater.inflate(
                    viewType,
                    parent,
                    false
                )
            )

            else -> throw IllegalArgumentException("Unsupported layout") // in case populated with a model we don't know how to display.
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val element = datas?.get(position) // assuming your list is called "elements"

        when (holder) {
            is TestBreakingNewsViewHolder -> holder.bind(element.breakingNewsItem as BreakingNewsItem)


            is TestNewsPostViewHolder ->{
                holder.bind(element.article as NewsPost)

                // RecyclerView Animation
                holder.itemView.animation = AnimationUtils.loadAnimation(holder.itemView.context, R.anim.slidein)

            }

        }
    }

    override fun getItemViewType(position: Int): Int {
        // assuming your list is called "elements"

        if (datas!!.get(position).type == 1) {
            return R.layout.layout_news_list_item;
        } else {
            return R.layout.layout_breaking_news_item;
        }
    }

    override fun getItemCount(): Int {

        return datas!!.size

    }



    inner class TestNewsPostViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val NewsPost_Title = itemView.blog_title
        val NewsPost_Image = itemView.blog_image
        val NewsPost_date = itemView.blog_date
        val NewsPost_Source = itemView.blog_source
        val NewsPost_Author = itemView.blog_author

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }

        fun bind(newsPost: NewsPost) {
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

    class TestBreakingNewsViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        val title = itemView.BreakingNewstextView

        fun bind(item: BreakingNewsItem) {

            title.setText("BREAKING NEWS: ${item.Title}")
        }
    }



    interface OnItemClickListener {
        fun onItemClick(adapterPosition: Int)
    }




}





