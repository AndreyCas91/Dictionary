package com.gb.dictionary.di.component

import com.gb.dictionary.di.modules.NavigationModules
import com.gb.dictionary.view.dictionary.DictionaryFragment
import com.gb.dictionary.view.dictionary.MainActivity
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        NavigationModules::class
    ]
)
@Singleton
interface Component {
    fun inject(mainActivity: MainActivity)

    fun inject(dictionaryFragment: DictionaryFragment)

}