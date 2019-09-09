package com.xebia.hpotier.data.remote.domain


import com.google.gson.annotations.SerializedName

data class CommercialOffers(
    @SerializedName("offers")  val offers: List<Offer>
)