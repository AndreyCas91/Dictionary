package com.gb.dictionary.view.main

import android.os.Bundle
import com.gb.dictionary.App
import com.gb.dictionary.R
import com.gb.dictionary.databinding.ActivityMainBinding
import com.gb.dictionary.view.base.BackButtonListener
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(R.layout.activity_main), MainView {

    private lateinit var binding: ActivityMainBinding

    private val navigator = AppNavigator(this, R.id.container)

    private val presenter by moxyPresenter { MainActivityPresenter(App.instance.router) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.inputLayout.setEndIconOnClickListener {
            presenter.getWord(binding.inputEditText.text.toString())
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.instance.navigationHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        App.instance.navigationHolder.removeNavigator()
    }

    override fun onBackPressed() {
        super.onBackPressed()

        supportFragmentManager.fragments.forEach {
            if (it is BackButtonListener && it.backPressed()) {
                return
            }
        }
        presenter.backPressed()
    }
}