package com.hankkin.jetpack_note.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hankkin.jetpack_note.data.Component
import com.hankkin.jetpack_note.databinding.ListItemHomeBinding

class HomeListAdapter : ListAdapter<Component,HomeListAdapter.ViewHolder>((ComponentDiffCallback())){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ListItemHomeBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.apply {
            bind(createOnClickListener(item.id),item)
            itemView.tag = item
        }
    }

    private fun createOnClickListener(plantId: String): View.OnClickListener {
        return View.OnClickListener {

        }
    }


    class ViewHolder(
        private val binding: ListItemHomeBinding
    ): RecyclerView.ViewHolder(binding.root){
        fun bind(listener: View.OnClickListener, item: Component) {
            binding.apply {
                clickListener = listener
                component = item
                executePendingBindings()
            }
        }
    }
}

private class ComponentDiffCallback : DiffUtil.ItemCallback<Component>() {

    override fun areItemsTheSame(oldItem: Component, newItem: Component): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Component, newItem: Component): Boolean {
        return oldItem == newItem
    }
}