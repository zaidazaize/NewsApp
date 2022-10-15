package com.example.newsapp.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.databinding.ListitemBinding
import com.example.newsapp.newsdata.News

class HomeAdapter : ListAdapter<News, HomeAdapter.HomeViewHolder>(DiffCallBack()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
     return   HomeViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class HomeViewHolder(private val binding: ListitemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup): HomeViewHolder {
                val binding =ListitemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                return HomeViewHolder(binding)
            }
        }

        fun bind(news: News){
            binding.news = news
            binding.executePendingBindings()
        }

    }
}

class DiffCallBack : DiffUtil.ItemCallback<News>() {
    override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
        return oldItem == newItem
    }

}