package com.ict.mito.justodo.ui.point

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ict.mito.justodo.infla.repository.ToDoInfoRepository
import javax.inject.Inject

/**
 * Created by mitohato14 on 2019-02-28.
 */
class PointViewModelFactory private constructor(
    private val repository: ToDoInfoRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        PointViewModel(
            repository
        ) as T

    class Provider @Inject constructor(
        private val repository: ToDoInfoRepository
    ) {
        fun provide(): PointViewModelFactory = PointViewModelFactory(repository)
    }
}
