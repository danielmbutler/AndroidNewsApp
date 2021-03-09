package com.example.newsapp.api

import android.icu.text.CaseMap
import com.example.newsapp.models.BreakingNewsItem

object BreakingNewsConstant {

    fun getBreakingNewsItems() : ArrayList<BreakingNewsItem>{
        val list = arrayListOf<BreakingNewsItem>()

        val item1 = BreakingNewsItem("Covid 19 Outbreak")
        val item2 = BreakingNewsItem("Earthquake on Mars")
        val item3 = BreakingNewsItem("Hell Freezes Over")
        val item4 = BreakingNewsItem("Covid 19 Outbreak")
        val item5 = BreakingNewsItem("Earthquake on Mars")
        val item6 = BreakingNewsItem("Hell Freezes Over")
        list.add(item1)
        list.add(item2)
        list.add(item3)
        list.add(item4)
        list.add(item5)
        list.add(item6)

        return list

    }
}