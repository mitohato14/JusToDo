package com.ict.mito.justodo.ui.todo.list.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ict.mito.justodo.domain.ToDoInfo
import com.ict.mito.justodo.domain.livedata.ToDoInfoLiveDataFactory
import com.ict.mito.justodo.domain.repository.ToDoInfoRepository
import io.reactivex.rxkotlin.subscribeBy
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
            repository.getById(value).subscribeBy(
                    onSuccess = {
                        todo = MutableLiveData(it)
                        dateString = Date(
                                todo.value?.deadlineDate
                                ?: System.currentTimeMillis()
                        ).toString()
                    },
                    onError = {
                        todo
                    }
            )
            field = value
    }

    fun updateToDo() = scope.launch(Dispatchers.IO) {
        todo.value?.let { repository.store(it) }
    }
}