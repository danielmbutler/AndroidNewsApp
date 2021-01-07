package com.example.newsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.models.NewsPost
import getData
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import org.json.JSONArray


class MainActivity : AppCompatActivity(), NewsRecyclerAdapter.OnItemClickListener {
    private var items: List<NewsPost> = ArrayList()

    private lateinit var newsAdapter: NewsRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch(Dispatchers.IO) {
            val apires = async { getData(API().NewsLink) }


            if (apires.await().toString() == "") {
                println("error")
            } else {
                withContext(Dispatchers.Main){
                    initRecyclerView()
                    val data = apires.await()

                    withContext(Dispatchers.Main){

                            addDataSet(data)


                        }



                    // Your code here
                }
            }
        }


    }

    suspend fun addDataSet(data: JSONArray) {


        val data = DataSource.createDataSet(data)
        newsAdapter.submitList(data)
        items = data
        }


    private fun initRecyclerView(){

        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            val topSpacingDecoration = TopSpacingItemDeclaration(30)
            addItemDecoration(topSpacingDecoration)
            newsAdapter = NewsRecyclerAdapter(this@MainActivity)
            recycler_view.adapter = newsAdapter


        }

        // WITHOUT APPLY Method
//        recycler_view.layoutManager = LinearLayoutManager(this@MainActivity)
//        newsAdapter = NewsRecyclerAdapter()
//        recycler_view.adapter = newsAdapter
    }

    override fun onItemClick(adapterPosition: Int) {
        //Toast.makeText(this,"Item $adapterPosition clicked",Toast.LENGTH_SHORT).show()
        val ClickedItem = items.get(adapterPosition)
        println(ClickedItem.content)

        // change to article view
        intent = Intent(this, ArticleActivity::class.java)
        intent.putExtra("ArticleTitle", ClickedItem.title)
        intent.putExtra("ArticleBody", ClickedItem.content)
        intent.putExtra("ArticleImage", ClickedItem.image)
        intent.putExtra("ArticleDate", ClickedItem.date)

        startActivity(intent)
    }
}