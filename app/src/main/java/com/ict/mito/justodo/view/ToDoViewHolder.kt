package com.ict.mito.justodo.view

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ict.mito.justodo.databinding.CardTodoBinding
import com.ict.mito.justodo.model.ToDoInfo

class ToDoViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    var binding: CardTodoBinding? = null

    init {
        bind()
    }

    fun bind() {
        if (binding == null) {
            binding = DataBindingUtil.bind(view)
        }
    }

    fun unbind() {
        binding?.unbind()
    }

    fun setToDoInfo(toDoInfo: ToDoInfo) {
        binding?.todoInfo = toDoInfo
    }
}