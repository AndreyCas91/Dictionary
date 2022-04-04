package com.gb.dictionary.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gb.dictionary.model.data.DataModel
import kotlinx.coroutines.*
import timber.log.Timber

abstract class BaseViewModel(
    protected val mutableList: MutableLiveData<List<DataModel>> = MutableLiveData()
) : ViewModel() {

    protected val viewModelCoroutineScope = CoroutineScope(
        Dispatchers.Main
                + SupervisorJob()
                + CoroutineExceptionHandler {_, throwble ->
            Timber.w(throwble, "Error thread $throwble")
        }
    )

    open fun getWord(word: String): LiveData<List<DataModel>> = mutableList

    override fun onCleared() {
        super.onCleared()
        cancelJob()
    }

    protected fun cancelJob(){
        viewModelCoroutineScope.coroutineContext.cancelChildren()
    }

}