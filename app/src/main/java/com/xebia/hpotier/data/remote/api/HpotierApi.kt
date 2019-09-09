package com.xebia.hpotier.data.remote.api

import com.xebia.hpotier.data.remote.domain.Book
import com.xebia.hpotier.data.remote.domain.CommercialOffers
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface HpotierApi {

    @GET("books")
    fun getBooks(): Single<ArrayList<Book>>

    @GET("books/{ids}/commercialOffers")
    fun commercialOffers(@Path("ids") test: String): Single<CommercialOffers>
}