package com.gb.dictionary.view.dictionary

import com.gb.dictionary.model.data.DataModel
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.Skip

interface DictionaryView: MvpView {
    @AddToEndSingle
    fun updateList(words: List<DataModel>)

    @Skip
    fun showError(message: String?)
}