package com.gb.dictionary.di.modules

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NavigationModules {

    @Provides
    @Singleton
    fun providesCicerone(): Cicerone<Router>{
        return Cicerone.create()
    }

    @Provides
    @Singleton
    fun providesNavigationHolder(cicerone: Cicerone<Router>): NavigatorHolder{
        return cicerone.getNavigatorHolder()
    }

    @Provides
    @Singleton
    fun providesRouter(cicerone: Cicerone<Router>): Router{
        return cicerone.router
    }

}