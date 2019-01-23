package com.ict.mito.justodo.ui.todo.list.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ict.mito.justodo.domain.ToDoInfo
import com.ict.mito.justodo.domain.repository.ToDoInfoRepository

/**
 * Created by mitohato14 on 2019-01-23.
 */
class ToDoDetailViewModel(
    private val repository: ToDoInfoRepository
) : ViewModel() {
    val todo: LiveData<ToDoInfo> = MutableLiveData()
}