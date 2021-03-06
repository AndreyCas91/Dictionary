package com.gb.dictionary.view.dictionary

import androidx.lifecycle.LiveData
import com.gb.dictionary.model.data.DataModel
import com.gb.dictionary.model.domain.IApiWordsRepos
import com.gb.dictionary.model.domain.ILocalWordsRepos
import com.gb.dictionary.viewmodel.BaseViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class DictionaryViewModel(
    private val apiWordsRepos: IApiWordsRepos,
    private val localWordsRepos: ILocalWordsRepos
) : BaseViewModel() {

    var job: Job? = null
    override fun getWord(word: String, isOnline: Boolean): LiveData<List<DataModel>> {
        job?.cancel()
        job = viewModelCoroutineScope.launch {
            mutableList.postValue(apiWordsRepos.getWords(word))
            localWordsRepos.insertWords(word)
        }


        return super.getWord(word, isOnline)
    }

}