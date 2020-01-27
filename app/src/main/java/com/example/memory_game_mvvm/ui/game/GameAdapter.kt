package com.example.memory_game_mvvm.ui.game

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AbsListView

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.memory_game_mvvm.databinding.ListItemGameBinding
import com.example.memory_game_mvvm.model.Card

class CardAdapter(val clickListener: GameClickListener) : ListAdapter<Card, CardAdapter.ViewHolder>(GameNightDiffCallback()) {
    var data =  listOf<Card>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val item = getItem(position)
        holder.bind( getItem(position)!!, clickListener)
    }

    class ViewHolder private constructor(val binding: ListItemGameBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Card, clickListener: GameClickListener) {
            binding.card = item
            binding.clickListener = clickListener
            binding.executePendingBindings()

        }
        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemGameBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

}
class GameNightDiffCallback : DiffUtil.ItemCallback<Card>(){
    override fun areItemsTheSame(oldItem: Card, newItem: Card): Boolean {
        return  oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: Card, newItem: Card): Boolean {
        return oldItem.id == newItem.id
    }


}

class GameClickListener(val clickListener: (card: Card) -> Unit ){
    fun onClick(card: Card) =  clickListener(card)
}
