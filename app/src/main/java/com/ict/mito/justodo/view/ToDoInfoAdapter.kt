package com.ict.mito.justodo.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import androidx.recyclerview.widget.RecyclerView
import com.ict.mito.justodo.domain.ToDoInfo

class ToDoInfoAdapter(private val todoInfoList: ObservableArrayList<ToDoInfo>)
    : RecyclerView.Adapter<ToDoViewHolder>() {

    init {
        todoInfoList.addOnListChangedCallback(
                object : ObservableList.OnListChangedCallback<ObservableArrayList<ToDoInfo>>() {
                    override fun onChanged(sender: ObservableArrayList<ToDoInfo>?) {
                        notifyDataSetChanged()
                    }

                    override fun onItemRangeRemoved(sender: ObservableArrayList<ToDoInfo>?, positionStart: Int, itemCount: Int) {
                        notifyItemRangeRemoved(positionStart, itemCount)
                    }

                    override fun onItemRangeMoved(sender: ObservableArrayList<ToDoInfo>?, fromPosition: Int, toPosition: Int, itemCount: Int) {
                        for (i in 0..itemCount) {
                            notifyItemMoved(
                                    fromPosition + i,
                                    toPosition + i
                            )
                        }
                    }

                    override fun onItemRangeInserted(sender: ObservableArrayList<ToDoInfo>?, positionStart: Int, itemCount: Int) {
                        notifyItemRangeInserted(
                                positionStart,
                                itemCount
                        )
                    }

                    override fun onItemRangeChanged(sender: ObservableArrayList<ToDoInfo>?, positionStart: Int, itemCount: Int) {
                        notifyItemRangeChanged(
                                positionStart,
                                itemCount
                        )
                    }
                }
        )
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
