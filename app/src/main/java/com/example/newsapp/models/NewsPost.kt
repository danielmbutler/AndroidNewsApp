package com.example.newsapp.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize

public data class NewsPost (
    var title   : String,
    var image   : String,
    var date    : String,
    var content : String,
    var source  : String,
    var author  : String
) : Parcelable {
}