package com.gb.dictionary.view.dictionary

import android.util.Log
import androidx.lifecycle.LiveData
import com.gb.dictionary.model.data.DataModel
import com.gb.dictionary.model.domain.ApiWordsRepos
import com.gb.dictionary.model.network.ApiHolder
import com.gb.dictionary.viewmodel.BaseViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class DictionaryViewModel (
    private val apiWordsRepos: ApiWordsRepos = ApiWordsRepos(ApiHolder.ApiService)
        ): BaseViewModel() {

    override fun getWord(word: String): LiveData<List<DataModel>> {

        compositeDisposable.add(
            apiWordsRepos.getWords(word)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    mutableList.value = it
                },{
                    Log.d("Error loading", it.message.toString())
                })
        )
        return super.getWord(word)
    }

}