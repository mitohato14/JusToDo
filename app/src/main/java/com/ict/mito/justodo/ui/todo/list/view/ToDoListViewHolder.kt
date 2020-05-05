package com.ict.mito.justodo.ui.todo.list.view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.core.animation.doOnEnd
import androidx.core.animation.doOnStart
import androidx.core.view.doOnLayout
import androidx.core.view.doOnNextLayout
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.ict.mito.justodo.databinding.CardBaseLayoutBinding
import com.ict.mito.justodo.domain.ToDoInfo
import com.ict.mito.justodo.utils.getValueAnimator

class ToDoListViewHolder(private val binding: CardBaseLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {

    private var originalHeightWidthPair = Pair(
        0,
        0
    )
    private var expandedHeightWidthPair = Pair(
        0,
        0
    )

    fun bind(toDoInfo: ToDoInfo) {
        binding.todoInfo = toDoInfo
        binding.root.setOnClickListener {
            expandItem(
                holder = this,
                expand = true
            )
        }
        binding.executePendingBindings()
        getViewHeightAndWidth()
    }

    private fun getViewHeightAndWidth() {
        binding.root.doOnLayout { view ->
            originalHeightWidthPair = Pair(
                view.height,
                view.width
            )
            binding.cardTodoDetail.root.isVisible = true
            binding.root.doOnNextLayout {
                expandedHeightWidthPair = Pair(
                    it.height,
                    it.width
                )

                binding.cardTodoDetail.root.post { binding.cardTodoDetail.root.isVisible = false }
            }
        }
    }

    fun unbind() {
        binding.unbind()
    }

    private fun expandItem(
        holder: ToDoListViewHolder,
        expand: Boolean
    ) {
        val animator = getValueAnimator(
            expand,
            1000,
            AccelerateDecelerateInterpolator()
        ) { progress ->
            holder.binding.root.layoutParams.height =
                (originalHeightWidthPair.first +
                    (expandedHeightWidthPair.first - originalHeightWidthPair.first)
                    * progress).toInt()
            holder.binding.root.layoutParams.width =
                (originalHeightWidthPair.second +
                    (expandedHeightWidthPair.second - originalHeightWidthPair.second)
                    * progress).toInt()

            holder.binding.root.requestLayout()
        }

        if (expand) {
            animator.doOnStart {
                holder.binding.cardTodoDetail.root.isVisible = true
                holder.binding.cardTodo.root.isVisible = false
            }
        } else {
            animator.doOnEnd {
                holder.binding.cardTodoDetail.root.isVisible = false
                holder.binding.cardTodo.root.isVisible = false
            }
        }

        animator.start()
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
