package com.gb.dictionary.view.dictionary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import com.gb.dictionary.App
import com.gb.dictionary.databinding.FragmentDictionaryBinding
import com.gb.dictionary.model.data.DataModel
import com.gb.dictionary.model.domain.ApiWordsRepos
import com.gb.dictionary.model.network.ApiHolder
import com.gb.dictionary.view.base.BackButtonListener
import com.gb.dictionary.view.dictionary.adapter.DictionaryAdapter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class DictionaryFragment: MvpAppCompatFragment(), DictionaryView, BackButtonListener{

    private var _binding: FragmentDictionaryBinding? = null
    private val binding
        get() = _binding!!

    private val presenter by moxyPresenter {
        DictionaryFragmentPresenter(
            App.instance.router,
            ApiWordsRepos(ApiHolder.ApiService),
            initWord.toString()
        )
    }

    private val adapter by lazy {
        DictionaryAdapter()
    }

    private val initWord by lazy {
        requireArguments().getString(WORD_KEY)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDictionaryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.rvResultSearch.layoutManager = LinearLayoutManager(requireContext())
        binding.rvResultSearch.adapter = adapter
    }

    override fun backPressed(): Boolean {
       presenter.backPressed()
        return true
    }

    companion object{

        const val WORD_KEY = "work key"

        fun newInstance(word: String): DictionaryFragment{
            return DictionaryFragment().apply {
                arguments = bundleOf(WORD_KEY to word)
            }
        }
    }

    override fun updateList(words: List<DataModel>) {
        adapter.submitList(words)
    }

    override fun showError(message: String?) {
        Toast.makeText(requireContext(), message.orEmpty(), Toast.LENGTH_SHORT)
            .show()
    }
}