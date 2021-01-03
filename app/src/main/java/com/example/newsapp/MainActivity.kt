package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import getData
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import org.json.JSONArray


class MainActivity : AppCompatActivity() {

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
        }


    private fun initRecyclerView(){

        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            val topSpacingDecoration = TopSpacingItemDeclaration(30)
            addItemDecoration(topSpacingDecoration)
            newsAdapter = NewsRecyclerAdapter()
            recycler_view.adapter = newsAdapter
        }

        // WITHOUT APPLY Method
//        recycler_view.layoutManager = LinearLayoutManager(this@MainActivity)
//        newsAdapter = NewsRecyclerAdapter()
//        recycler_view.adapter = newsAdapter
    }
}