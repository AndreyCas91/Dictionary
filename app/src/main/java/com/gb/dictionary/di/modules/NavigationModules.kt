package com.gb.dictionary.di.modules

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router

class NavigationModules {

    val cicerone: Cicerone<Router> by lazy { Cicerone.create() }

    fun providesNavigationHolder(cicerone: Cicerone<Router>): NavigatorHolder {
        return cicerone.getNavigatorHolder()
    }

    fun providesRouter(cicerone: Cicerone<Router>): Router {
        return cicerone.router
    }

}