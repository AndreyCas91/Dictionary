package com.gb.dictionary.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gb.dictionary.data.entities.WordHistory


@Dao
interface WordDao {

    @Query("SELECT * FROM word_history")
    fun getAllWord(): List<WordHistory>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWord(word: List<WordHistory>)
}