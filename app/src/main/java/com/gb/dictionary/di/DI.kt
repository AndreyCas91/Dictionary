package com.gb.dictionary.di

import androidx.room.Room
import com.gb.dictionary.data.DatabaseWord
import com.gb.dictionary.di.modules.NavigationModules
import com.gb.dictionary.model.datasours.DataSoursLocal
import com.gb.dictionary.model.datasours.RoomDatabaseImplementation
import com.gb.dictionary.model.domain.ApiWordsRepos
import com.gb.dictionary.model.domain.IApiWordsRepos
import com.gb.dictionary.model.domain.ILocalWordsRepos
import com.gb.dictionary.model.domain.LocalWordsRepos
import com.gb.dictionary.model.network.ApiHolder
import com.gb.dictionary.view.dictionary.DictionaryViewModel
import com.gb.dictionary.view.wordhistory.WordHistoryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object DI {
    val app = module {
        single {
            Room.databaseBuilder(get(), DatabaseWord::class.java, "word_history_database").build()
        }
        single { get<DatabaseWord>().wordDao() }
        single { NavigationModules().cicerone }
        single { NavigationModules().providesNavigationHolder(cicerone = get()) }
        single { NavigationModules().providesRouter(cicerone = get()) }
    }

    val mineScreen = module {
        single { ApiHolder().ApiService }
        single<IApiWordsRepos> { ApiWordsRepos(apiService = get()) }
        viewModel { DictionaryViewModel(apiWordsRepos = get(), localWordsRepos = get()) }
        viewModel { WordHistoryViewModel(localWordsRepos = get()) }

        single<DataSoursLocal> { RoomDatabaseImplementation(wordDao = get()) }
        single<ILocalWordsRepos> { LocalWordsRepos(dataSoursLocal = get()) }
    }
}