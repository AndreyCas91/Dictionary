package com.gb.dictionary.view.wordhistory.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gb.dictionary.databinding.ItemHistorySearchBinding
import com.gb.dictionary.model.data.DataModel

class WordHistoryAdapter: ListAdapter<DataModel, WordHistoryAdapter.WordsHistoryViewHolder>(ApiWordsItemCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordsHistoryViewHolder {
        return WordsHistoryViewHolder(ItemHistorySearchBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: WordsHistoryViewHolder, position: Int) {
        holder.showWork(currentList[position])
    }

    inner class WordsHistoryViewHolder(private val vb: ItemHistorySearchBinding) : RecyclerView.ViewHolder(vb.root){

        fun showWork(dataModel: DataModel){
            vb.textViewWord.text = dataModel.text
        }
    }
}

object ApiWordsItemCallback: DiffUtil.ItemCallback<DataModel>(){
    override fun areItemsTheSame(oldItem: DataModel, newItem: DataModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: DataModel, newItem: DataModel): Boolean {
        return oldItem == newItem
    }

}