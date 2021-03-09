package com.example.newsapp.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class NewsPost (
    var title   : String,
    var image   : String,
    var date    : String,
    var content : String,
    var source  : String,
    var author  : String,
    var viewType: Int =  2
) : Parcelable {
}

@Parcelize
data class BreakingNewsItem(
    val Title: String,
    val viewType: Int = 1
) : Parcelable