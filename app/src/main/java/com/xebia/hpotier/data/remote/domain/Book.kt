package com.xebia.hpotier.data.remote.domain

import com.google.gson.annotations.SerializedName

class Book(
    @SerializedName("isbn") val isbn: String,
    @SerializedName("title") val title: String,
    @SerializedName("price") val price: Int,
    @SerializedName("cover") val cover: String,
    @SerializedName("synopsis") val synopsis: List<String>
)