package com.gb.dictionary.model.datasours

import com.gb.dictionary.data.dao.WordDao
import com.gb.dictionary.data.entities.WordHistory
import com.gb.dictionary.model.data.DataModel

class RoomDatabaseImplementation(private val wordDao: WordDao) : DataSoursLocal {
    override suspend fun getWords(): List<DataModel> {
        val mapListResult = ArrayList<DataModel>()

        if (!wordDao.getAllWord().isNullOrEmpty()) {
            for (wordData in wordDao.getAllWord()) {
                mapListResult.add(DataModel(wordData.word))
            }
        }

        return mapListResult
    }

    override suspend fun insertWords(search: String) {
        val wordHistoryList: List<WordHistory> = listOf(
            WordHistory(word = search)
        )

        wordDao.insertWord(wordHistoryList)
    }
}