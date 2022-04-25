package com.gb.dictionary.model.domain

import com.gb.dictionary.model.data.DataModel
import com.gb.dictionary.model.datasours.DataSoursLocal

class LocalWordsRepos(private val dataSoursLocal: DataSoursLocal): ILocalWordsRepos {


    override suspend fun insertWords(search: String){
        dataSoursLocal.insertWords(search)
    }

    override suspend fun getWords(search: String): List<DataModel> {
        return dataSoursLocal.getWords()
    }
}
