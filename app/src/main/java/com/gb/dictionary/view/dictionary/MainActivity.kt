package com.gb.dictionary.view.dictionary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gb.dictionary.R
import com.gb.dictionary.databinding.ActivityMainBinding
import com.gb.dictionary.screens.AppScreens
import com.gb.dictionary.view.base.BackButtonListener
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import org.koin.android.ext.android.inject
import timber.log.Timber

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var binding: ActivityMainBinding

    private val router: Router by inject()

    private val navigationHolder: NavigatorHolder by inject()

    private val navigator = AppNavigator(this, R.id.container)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.inputLayout.setEndIconOnClickListener {
            router.replaceScreen(AppScreens.dictionaryScreen(binding.inputEditText.text.toString()))
        }

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