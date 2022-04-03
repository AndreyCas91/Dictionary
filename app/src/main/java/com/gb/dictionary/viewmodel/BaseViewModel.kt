package com.gb.dictionary.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gb.dictionary.model.data.DataModel
import io.reactivex.rxjava3.disposables.CompositeDisposable

abstract class BaseViewModel(
    protected val mutableList: MutableLiveData<List<DataModel>> = MutableLiveData(),
    protected val compositeDisposable: CompositeDisposable = CompositeDisposable()
) : ViewModel() {

    open fun getWord(word: String): LiveData<List<DataModel>> = mutableList

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}