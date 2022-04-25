package com.gb.dictionary.view.wordhistory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.gb.dictionary.databinding.FragmentWordHistoryBinding
import com.gb.dictionary.model.data.DataModel
import com.gb.dictionary.view.base.BackButtonListener
import com.gb.dictionary.view.wordhistory.adapter.WordHistoryAdapter
import com.github.terrakok.cicerone.Router
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class WordHistoryFragment : Fragment(), BackButtonListener {


    private var _binding: FragmentWordHistoryBinding? = null
    private val binding
        get() = _binding!!

    private val router: Router by inject()

    private val viewModel: WordHistoryViewModel by viewModel()

    private val adapter by lazy {
        WordHistoryAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWordHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getWord(word = "", false).observe(viewLifecycleOwner) {
            rangerData(it)
        }

        binding.rvDatabase.layoutManager = LinearLayoutManager(requireContext())
        binding.rvDatabase.adapter = adapter


    }

    private fun rangerData(words: List<DataModel>) {
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

    companion object {

        fun newInstance(): WordHistoryFragment {
            return WordHistoryFragment()
        }
    }

}