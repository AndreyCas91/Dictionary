package com.gb.dictionary.view.dictionary

import androidx.lifecycle.LiveData
import com.gb.dictionary.model.data.DataModel
import com.gb.dictionary.model.domain.IApiWordsRepos
import com.gb.dictionary.viewmodel.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber

class DictionaryViewModel(
    private val apiWordsRepos: IApiWordsRepos
) : BaseViewModel() {

    override fun getWord(word: String): LiveData<List<DataModel>> {
        cancelJob()

        try {
            viewModelCoroutineScope.launch {
                withContext(Dispatchers.IO) {
                    mutableList.postValue(apiWordsRepos.getWords(word))
                }
            }
        }catch (e: Throwable){
            Timber.w(e, "Error $e")
        }
        return super.getWord(word)
    }

}