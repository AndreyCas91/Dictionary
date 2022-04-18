package com.gb.dictionary.di

import com.gb.dictionary.di.modules.NavigationModules
import com.gb.dictionary.model.domain.ApiWordsRepos
import com.gb.dictionary.model.domain.IApiWordsRepos
import com.gb.dictionary.model.network.ApiHolder
import com.gb.dictionary.view.dictionary.DictionaryViewModel
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object DI {
    val app = module {
        single<Cicerone<Router>> { NavigationModules().cicerone }
        single<NavigatorHolder> { NavigationModules().providesNavigationHolder(cicerone = get()) }
        single<Router> { NavigationModules().providesRouter(cicerone = get()) }
    }

    val mineScreen = module {
        single{ ApiHolder.ApiService }
        single<IApiWordsRepos> { ApiWordsRepos(apiService = get()) }
        viewModel { DictionaryViewModel(apiWordsRepos = get()) }
    }
}