package com.gb.dictionary.view.dictionary

import com.gb.dictionary.model.domain.IApiWordsRepos
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class DictionaryFragmentPresenter(
    private val router: Router,
    private val apiWordsRepos: IApiWordsRepos,
    private val word: String
): MvpPresenter<DictionaryView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        loadData()
    }

    private fun loadData() {
        apiWordsRepos.getWords(word)
            .subscribeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.updateList(it)
            },{
                viewState.showError(it.message)
            })
    }


    fun backPressed(): Boolean {
        return true
    }

}