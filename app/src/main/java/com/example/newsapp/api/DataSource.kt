package com.example.newsapp.api

import android.util.Log
import com.example.newsapp.models.NewsPost
import org.json.JSONArray


class DataSource{



    companion object{

        fun createDataSet(ApiData : JSONArray): ArrayList<NewsPost>{

            Log.d("data received", ApiData.toString())

            //get data
            val list = ArrayList<NewsPost>()



                    for (i in 0 until ApiData.length()) {

                        val data   = ApiData.getJSONObject(i)
                        val source  = data.getJSONObject("source")

                        val title       = data.getString("title")
                        val image       = data.getString("urlToImage")
                        val date        = data.getString("publishedAt")
                        val sourcename  = source.getString("name")
                        val author      = data.getString("author")
                        val content   = data.getString("content")

                        list.add(
                            NewsPost(
                                title,
                                image,
                                "date: ${date.replace("T"," ").replace("Z","")}",
                                content,
                                sourcename,
                                "author: $author"

                            )
                        )
                    }




                        return list
                    }
                }

            }


