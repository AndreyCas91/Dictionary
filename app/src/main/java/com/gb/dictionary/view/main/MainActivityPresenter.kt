package com.gb.dictionary.view.main

import com.gb.dictionary.screens.AppScreens
import com.gb.dictionary.view.base.IWordSearch
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class MainActivityPresenter(
    private val router: Router
): MvpPresenter<MainView>(), IWordSearch {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()


    }



    fun backPressed() {
        router.exit()
    }

    override fun getWord(word: String) {
        router.replaceScreen(AppScreens.dictionaryScreen(word))
    }
}