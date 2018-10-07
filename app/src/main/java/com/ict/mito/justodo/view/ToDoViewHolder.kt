package com.ict.mito.justodo.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ict.mito.justodo.databinding.CardTodoBinding
import com.ict.mito.justodo.model.ToDoInfo

class ToDoViewHolder(private val binding: CardTodoBinding) : RecyclerView.ViewHolder(binding.root) {

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
        ): ToDoViewHolder = ToDoViewHolder(
            CardTodoBinding.inflate(
                    inflater,
                    parent,
                    attachToRoot
            )
        )
    }
}
