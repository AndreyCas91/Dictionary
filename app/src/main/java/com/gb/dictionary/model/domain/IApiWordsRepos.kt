package com.gb.dictionary.model.domain

import com.gb.dictionary.model.data.DataModel
import io.reactivex.rxjava3.core.Single

interface IApiWordsRepos {

    fun getWords(search: String): Single<List<DataModel>>
}