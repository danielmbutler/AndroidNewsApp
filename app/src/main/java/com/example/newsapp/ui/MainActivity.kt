package com.example.newsapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.*
import com.example.newsapp.api.API
import com.example.newsapp.api.BreakingNewsConstant
import com.example.newsapp.api.DataSource
import com.example.newsapp.models.NewsPost
import com.example.newsapp.api.getData
import com.example.newsapp.models.Data
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import org.json.JSONArray


class MainActivity : AppCompatActivity(), TestAdapter.OnItemClickListener {
    private var items: List<Data> = listOf()

    private lateinit var newsAdapter: TestAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch(Dispatchers.IO) {
            val apires = async { getData(API().NewsLink) }


            if (apires.await().toString() == "") {
                println("error")
            } else {
                withContext(Dispatchers.Main){

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

        //Breaking News Items

        val BreakingNewsItems = BreakingNewsConstant.getBreakingNewsItems()

        //newslist.add(BreakingNewsItems)



        val data = DataSource.createDataSet(data)



        // merging braking news Items and Articles together
        val newslist = Data().mergeRandom(data,BreakingNewsItems)

        if (newslist != null) {
            initRecyclerView(newslist)
        }


        items = newslist!!
        }


    private fun initRecyclerView(list: List<Data>){

        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            val topSpacingDecoration = TopSpacingItemDeclaration(30)
            addItemDecoration(topSpacingDecoration)
            newsAdapter = TestAdapter(this@MainActivity,list, this@MainActivity)

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
        println(ClickedItem.article?.title)
        Log.d("NewsActivity", "clicked content: ${ClickedItem.article?.title}")

        // change to article view
        intent = Intent(this, ArticleActivity::class.java)
        intent.putExtra("ArticleTitle", ClickedItem.article?.title)
        intent.putExtra("ArticleBody", ClickedItem.article?.content)
        intent.putExtra("ArticleImage", ClickedItem.article?.image)
        intent.putExtra("ArticleDate", ClickedItem.article?.date)

        startActivity(intent)
    }
}