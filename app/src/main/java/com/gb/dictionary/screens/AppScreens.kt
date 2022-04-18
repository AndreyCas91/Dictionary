package com.gb.dictionary.screens

import com.gb.dictionary.view.dictionary.DictionaryFragment
import com.gb.dictionary.view.wordhistory.WordHistoryFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object AppScreens {
    fun dictionaryScreen(word: String) = FragmentScreen{
        DictionaryFragment.newInstance(word)
    }

    fun wordHistoryScreen() = FragmentScreen{
        WordHistoryFragment.newInstance()
    }
}