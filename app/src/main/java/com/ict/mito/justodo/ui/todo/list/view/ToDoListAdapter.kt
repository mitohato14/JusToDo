package com.ict.mito.justodo.ui.todo.list.view

import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ict.mito.justodo.domain.ToDoInfo

class ToDoListAdapter(private var todoInfoList: List<ToDoInfo>) :
  RecyclerView.Adapter<ToDoListViewHolder>() {

  var recyclerView: RecyclerView? = null

  fun setToDoListData(newData: List<ToDoInfo>) {
    todoInfoList = newData
    notifyDataSetChanged()
  }

  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): ToDoListViewHolder = ToDoListViewHolder.create(
    LayoutInflater.from(parent.context),
    parent,
    false
  )

  override fun getItemCount(): Int = todoInfoList.size

  override fun onBindViewHolder(
    holder: ToDoListViewHolder,
    position: Int
  ) {
    holder.bind(todoInfoList[position])
    holder.binding.root.setOnClickListener {
      TransitionManager.beginDelayedTransition(
        recyclerView,
        AutoTransition()
      )
      holder.switchExpand()
      notifyDataSetChanged()
    }
  }
}
