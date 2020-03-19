package com.ict.mito.justodo.ui.todo.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ict.mito.justodo.domain.ToDoInfo
import com.ict.mito.justodo.domain.livedata.ToDoInfoLiveDataFactory
import com.ict.mito.justodo.domain.repository.ToDoInfoRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.sql.Date
import kotlin.coroutines.CoroutineContext

/**
 * Created by mitohato14 on 2019-01-23.
 */
class ToDoDetailViewModel(
    private val repository: ToDoInfoRepository,
    toDoInfoLiveDataFactory: ToDoInfoLiveDataFactory
) : ViewModel() {
    private var parentJob = Job()
    private val mainCoroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Main
    private val scope = CoroutineScope(mainCoroutineContext)

    var todo: LiveData<ToDoInfo> = toDoInfoLiveDataFactory.create()
    var dateString: String = ""

    var id: Long = -1L
        set(value) {
            viewModelScope.launch(Dispatchers.IO) {
                todo = MutableLiveData(repository.getById(value))
                dateString = Date(
                    todo.value?.deadlineDate
                        ?: System.currentTimeMillis()
                ).toString()
            }
            field = value
        }

    fun updateToDo() = scope.launch(Dispatchers.IO) {
        todo.value?.let { repository.store(it) }
    }

    fun done() = scope.launch(Dispatchers.IO) {
        todo.value?.let { repository.done(it) }
    }

    fun undone() = scope.launch(Dispatchers.IO) {
        todo.value?.let { repository.undone(it) }
    }
}