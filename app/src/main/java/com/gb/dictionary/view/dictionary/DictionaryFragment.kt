package com.gb.dictionary.view.dictionary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.gb.dictionary.databinding.FragmentDictionaryBinding
import com.gb.dictionary.model.data.DataModel
import com.gb.dictionary.view.base.BackButtonListener
import com.gb.dictionary.view.dictionary.adapter.DictionaryAdapter
import com.github.terrakok.cicerone.Router
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class DictionaryFragment: Fragment(), BackButtonListener{


    private var _binding: FragmentDictionaryBinding? = null
    private val binding
        get() = _binding!!

    private val router: Router by inject()

    private val viewModel: DictionaryViewModel by viewModel()

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

        initWord?.let {
            viewModel.getWord(it).observe(viewLifecycleOwner, Observer{ list ->
                rangerData(list)
            })
        }


        binding.rvResultSearch.layoutManager = LinearLayoutManager(requireContext())
        binding.rvResultSearch.adapter = adapter


    }

    private fun rangerData(words: List<DataModel>){
        adapter.submitList(words)
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }



    override fun backPressed(): Boolean {
       router.exit()
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

}