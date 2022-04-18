package com.gb.dictionary.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gb.dictionary.data.dao.WordDao
import com.gb.dictionary.data.entities.WordHistory


@Database(entities = [WordHistory::class], version = 1, exportSchema = false)
abstract class DatabaseWord : RoomDatabase() {
    abstract fun wordDao(): WordDao
}