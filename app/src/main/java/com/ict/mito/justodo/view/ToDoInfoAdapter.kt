package com.ict.mito.justodo.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ict.mito.justodo.domain.ToDoInfo

class ToDoInfoAdapter(private var todoInfoList: List<ToDoInfo>)
    : RecyclerView.Adapter<ToDoViewHolder>() {

    fun setToDoListData(newData: List<ToDoInfo>) {
        todoInfoList = newData
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ToDoViewHolder = ToDoViewHolder.create(
            LayoutInflater.from(parent.context),
            parent,
            false
    )

    override fun getItemCount(): Int = todoInfoList.size

    override fun onBindViewHolder(
        holder: ToDoViewHolder,
        position: Int
    ) {
        holder.bind(todoInfoList[position])
    }
}
