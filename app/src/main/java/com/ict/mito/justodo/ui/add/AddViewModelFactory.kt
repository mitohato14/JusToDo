package com.ict.mito.justodo.ui.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ict.mito.justodo.model.ToDoInfoLiveDataFactory
import com.ict.mito.justodo.repository.ToDoInfoRepository
import javax.inject.Inject

/**
 * Created by mito on 2018/09/20.
 */
class AddViewModelFactory private constructor(
    private val repository: ToDoInfoRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
            AddViewModel(
                    repository = repository,
                    todoInfoLiveDataFactory = ToDoInfoLiveDataFactory()
            ) as T

    class Provider @Inject constructor(
        private val repository: ToDoInfoRepository
    ) {
        fun provide(): AddViewModelFactory = AddViewModelFactory(repository)
    }
}
