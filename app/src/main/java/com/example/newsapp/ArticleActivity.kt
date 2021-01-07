package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_article.*

class ArticleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)

        val Title = intent.getStringExtra("ArticleTitle")
        val Body = intent.getStringExtra("ArticleBody")
        val Image = intent.getStringExtra("ArticleImage")
        val date = intent.getStringExtra("ArticleDate")

        println(date)

        // set up text

        article_view_textview.text  = Title
        article_view_text_body.text = Body
        article_view_Date_Text.text = date
       article_view_Date_Text.setGravity(Gravity.CENTER_VERTICAL)

        //set up image
        val requestOptions = RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)

        Glide.with(this)
            .applyDefaultRequestOptions(requestOptions)
            .load(Image)
            .into(imageView)

    }
}