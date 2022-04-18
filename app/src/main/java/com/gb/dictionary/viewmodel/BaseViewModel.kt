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
        Dispatchers.IO
                + SupervisorJob()
                + CoroutineExceptionHandler {_, throwble ->
            Timber.w(throwble, "Error thread $throwble")
        }
    )

    open fun getWord(word: String, isOnline: Boolean): LiveData<List<DataModel>> = mutableList

    override fun onCleared() {
        super.onCleared()
        viewModelCoroutineScope.cancel()
        cancelJob()
    }

    protected fun cancelJob(){
        viewModelCoroutineScope.coroutineContext.cancel()
    }

}