package com.gb.dictionary.view.wordhistory

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gb.dictionary.R
import com.gb.dictionary.databinding.ActivityWordHistoryBinding
import com.gb.dictionary.screens.AppScreens
import com.gb.dictionary.view.base.BackButtonListener
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import org.koin.android.ext.android.inject
import timber.log.Timber

class WordHistoryActivity : AppCompatActivity(R.layout.activity_word_history) {

    private lateinit var binding: ActivityWordHistoryBinding

    private val router: Router by inject()

    private val navigationHolder: NavigatorHolder by inject()

    private val navigator = AppNavigator(this, R.id.container)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWordHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        router.replaceScreen(AppScreens.wordHistoryScreen())

        Timber.plant(Timber.DebugTree())
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigationHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigationHolder.removeNavigator()
    }

    override fun onBackPressed() {
        super.onBackPressed()

        supportFragmentManager.fragments.forEach {
            if (it is BackButtonListener && it.backPressed()) {
                return
            }
        }
        router.exit()
    }
}