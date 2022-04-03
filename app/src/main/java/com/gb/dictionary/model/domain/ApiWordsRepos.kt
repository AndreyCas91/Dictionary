package com.gb.dictionary.model.domain

import com.gb.dictionary.model.data.DataModel
import com.gb.dictionary.model.network.ApiService
import io.reactivex.rxjava3.core.Single

class ApiWordsRepos(private val apiService: ApiService): IApiWordsRepos {
    override fun getWords(search: String): Single<List<DataModel>> {
        return apiService.search(search)
    }
}
