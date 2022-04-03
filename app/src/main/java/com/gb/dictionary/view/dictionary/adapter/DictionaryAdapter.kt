package com.gb.dictionary.view.dictionary.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gb.dictionary.databinding.ItemResultSearchBinding
import com.gb.dictionary.model.data.DataModel

class DictionaryAdapter: ListAdapter<DataModel, DictionaryAdapter.WordsViewHolder>(ApiWordsItemCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordsViewHolder {
        return WordsViewHolder(ItemResultSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: WordsViewHolder, position: Int) {
        holder.showWork(currentList[position])
    }

    inner class WordsViewHolder(private val vb: ItemResultSearchBinding) : RecyclerView.ViewHolder(vb.root){

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