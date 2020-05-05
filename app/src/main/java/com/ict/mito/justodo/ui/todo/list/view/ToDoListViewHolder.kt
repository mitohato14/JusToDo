package com.ict.mito.justodo.ui.todo.list.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ict.mito.justodo.databinding.CardBaseLayoutBinding
import com.ict.mito.justodo.domain.ToDoInfo

class ToDoListViewHolder(val binding: CardBaseLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(toDoInfo: ToDoInfo) {
        binding.todoInfo = toDoInfo
        binding.executePendingBindings()
    }

    fun unbind() {
        binding.unbind()
    }

    companion object {
        fun create(
            inflater: LayoutInflater,
            parent: ViewGroup,
            attachToRoot: Boolean
        ): ToDoListViewHolder = ToDoListViewHolder(
            CardBaseLayoutBinding.inflate(
                inflater,
                parent,
                attachToRoot
            )
        )
    }
}
