package com.gb.dictionary.model.domain

import com.gb.dictionary.model.data.DataModel
import com.gb.dictionary.model.network.ApiService

class ApiWordsRepos(private val apiService: ApiService): IApiWordsRepos {
    override suspend fun getWords(search: String): List<DataModel> {
        return apiService.search(search).await()
    }
}
