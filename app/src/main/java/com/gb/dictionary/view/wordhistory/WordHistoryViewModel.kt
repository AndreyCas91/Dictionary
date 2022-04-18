package com.gb.dictionary.view.wordhistory

import androidx.lifecycle.LiveData
import com.gb.dictionary.model.data.DataModel
import com.gb.dictionary.model.domain.ILocalWordsRepos
import com.gb.dictionary.viewmodel.BaseViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class WordHistoryViewModel(
    private val localWordsRepos: ILocalWordsRepos
) : BaseViewModel() {

    var job: Job? = null

    override fun getWord(word: String, isOnline: Boolean): LiveData<List<DataModel>> {
        job?.cancel()
        job = viewModelCoroutineScope.launch {
            mutableList.postValue(localWordsRepos.getWords(word))
        }
        return super.getWord(word, isOnline)
    }

}