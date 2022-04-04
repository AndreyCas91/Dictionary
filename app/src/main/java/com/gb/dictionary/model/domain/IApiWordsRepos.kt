package com.gb.dictionary.model.domain

import com.gb.dictionary.model.data.DataModel

interface IApiWordsRepos {

    suspend fun getWords(search: String): List<DataModel>
}