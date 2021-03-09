package com.example.newsapp.models

import java.util.*
import kotlin.collections.ArrayList

class Data {
    // 1 is article, 2 is BreakingNewsItem
    var type = 0
    var article: NewsPost? = null
    var breakingNewsItem: BreakingNewsItem? = null
    fun merge(articles: ArrayList<NewsPost>, items: List<BreakingNewsItem?>): List<Data> {
        val datas: MutableList<Data> = ArrayList()
        for (article in articles) {
            val data = Data()
            data.article = article
            data.breakingNewsItem = null
            data.type = 1
            datas.add(data)
        }
        for (item in items) {
            val data = Data()
            data.article = null
            data.breakingNewsItem = item
            data.type = 2
            datas.add(data)
        }
        return datas
    }

    // merge random

    fun mergeRandom(articles: ArrayList<NewsPost>, items: List<BreakingNewsItem>): List<Data>? {
        val datas: MutableList<Data> = ArrayList()
        val random: MutableList<Int> = ArrayList() // random list to add data items to
        val maxLength = articles.size + items.size // totals size of both lists
        for (i in 0 until maxLength) {
            random.add(i) //list on ints from 1 to max length
        }
        while (random.size > 0) {
            // get random item
            val index: Int = Random().nextInt(random.size)
            val position = random[index]
            if (position <= articles.size - 1) {
                val data = Data()
                data.article = articles[position]
                data.breakingNewsItem = null
                data.type = 1
                datas.add(data)
            } else {
                val data = Data()
                data.article = null
                data.breakingNewsItem = items[position - articles.size]
                data.type = 2
                datas.add(data)
            }
            random.removeAt(index)
        }
        return datas
    }
}