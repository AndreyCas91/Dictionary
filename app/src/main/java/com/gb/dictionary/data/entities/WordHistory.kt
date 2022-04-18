package com.gb.dictionary.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word_history")
data class WordHistory(

    @PrimaryKey(autoGenerate = true) val id: Int = 0,

    @ColumnInfo(name = "word") val word: String

)

