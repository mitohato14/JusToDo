package com.ict.mito.justodo.ui.todo.list.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ict.mito.justodo.domain.repository.ToDoInfoRepository
import javax.inject.Inject

/**
 * Created by mitohato14 on 2019-01-23.
 */
class ToDoDetailViewModelFactory private constructor(
    private val repository: ToDoInfoRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ToDoDetailViewModel(repository) as T
    }

    class Provider @Inject constructor(
        private val repository: ToDoInfoRepository
    ) {
        fun provide(): ToDoDetailViewModelFactory = ToDoDetailViewModelFactory(repository)
    }
}