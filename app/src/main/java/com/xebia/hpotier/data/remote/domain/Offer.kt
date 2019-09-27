package com.xebia.hpotier.data.remote.domain

import com.google.gson.annotations.SerializedName

data class Offer(
    @SerializedName("sliceValue") val sliceValue: Int,
    @SerializedName("type") val type: String,
    @SerializedName("value") val value: Int
)