package com.ict.mito.justodo.ui.todo.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ict.mito.justodo.domain.ToDoInfo
import com.ict.mito.justodo.domain.livedata.ToDoInfoLiveDataFactory
import com.ict.mito.justodo.infla.repository.ToDoInfoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.sql.Date

/**
 * Created by mitohato14 on 2019-01-23.
 */
class ToDoDetailViewModel(
    private val repository: ToDoInfoRepository,
    toDoInfoLiveDataFactory: ToDoInfoLiveDataFactory
) : ViewModel() {

    val todo: LiveData<ToDoInfo>
        get() = _todo
    private val _todo: MutableLiveData<ToDoInfo> = toDoInfoLiveDataFactory.create()

    var dateString: String = ""

    var id: Long = -1L
        set(value) {
            viewModelScope.launch(Dispatchers.IO) {
                _todo.postValue(repository.getById(value))
                dateString = Date(
                    _todo.value?.deadlineDate
                        ?: System.currentTimeMillis()
                ).toString()
            }
            field = value
        }

    fun updateToDo() = viewModelScope.launch(Dispatchers.IO) {
        _todo.value?.let { repository.store(it) }
    }

    fun done() = viewModelScope.launch(Dispatchers.IO) {
        _todo.value?.let { repository.done(it) }
    }

    fun undone() = viewModelScope.launch(Dispatchers.IO) {
        _todo.value?.let { repository.undone(it) }
    }
}