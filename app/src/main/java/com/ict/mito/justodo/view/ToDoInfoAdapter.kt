package com.ict.mito.justodo.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ict.mito.justodo.R
import com.ict.mito.justodo.model.ToDoInfo

class ToDoInfoAdapter(private val todoInfoList: List<ToDoInfo>)
    : RecyclerView.Adapter<ToDoViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ToDoViewHolder {
        val view = LayoutInflater
                .from(parent.context)
                .inflate(
                        R.layout.card_todo,
                        parent,
                        false
                )

        return ToDoViewHolder(view)
    }

    override fun getItemCount(): Int = todoInfoList.size

    override fun onBindViewHolder(
        holder: ToDoViewHolder,
        position: Int
    ) {
        holder.setToDoInfo(todoInfoList[position])
    }
}
