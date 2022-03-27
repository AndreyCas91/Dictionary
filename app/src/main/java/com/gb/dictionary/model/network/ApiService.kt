package com.gb.dictionary.model.network

import com.gb.dictionary.model.data.DataModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("words/search")
    fun search(@Query("search") wordToSearch: String): Single<List<DataModel>>
}
