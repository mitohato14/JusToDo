package com.ict.mito.justodo.ui.todo.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ict.mito.justodo.infla.repository.ToDoInfoRepository
import javax.inject.Inject

/**
 * Created by mito on 2018/09/20.
 */
class ToDoListViewModelFactory private constructor(
    private val repository: ToDoInfoRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ToDoListViewModel(repository) as T
    }

    class Provider @Inject constructor(
        private val repository: ToDoInfoRepository
    ) {
        fun provide(): ToDoListViewModelFactory = ToDoListViewModelFactory(repository)
    }
}
