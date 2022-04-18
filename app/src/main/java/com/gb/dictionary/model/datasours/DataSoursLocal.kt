package com.gb.dictionary.model.datasours

import com.gb.dictionary.model.data.DataModel

interface DataSoursLocal {
    suspend fun getWords(): List<DataModel>

    suspend fun insertWords(search: String)
}