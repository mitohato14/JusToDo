package com.ict.mito.justodo.ui.todo.list

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.ViewModel
import com.ict.mito.justodo.domain.ToDoInfo
import com.ict.mito.justodo.domain.repository.ToDoInfoRepository
import io.reactivex.rxkotlin.subscribeBy

/**
 * Created by mito on 2018/09/04.
 */
class ToDoListViewModel(
    private val repository: ToDoInfoRepository
) : ViewModel() {
    val todos: ObservableArrayList<ToDoInfo> = ObservableArrayList()

    init {
        readAll()
    }

    private fun readAll() {
        repository.getAll().subscribeBy(
                onSuccess = {
                    todos.apply {
                        clear()
                        addAll(it)
                    }
                },
                onError = {
                    todos
                }
        )
    }
}
