package com.gb.dictionary.model.domain

interface ILocalWordsRepos: IApiWordsRepos {

    suspend fun insertWords(search: String)
}