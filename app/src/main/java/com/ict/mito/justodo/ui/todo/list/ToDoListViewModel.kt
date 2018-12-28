package com.ict.mito.justodo.ui.todo.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ict.mito.justodo.domain.ToDoInfo
import com.ict.mito.justodo.domain.repository.ToDoInfoRepository
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/**
 * Created by mito on 2018/09/04.
 */
class ToDoListViewModel(
    private val repository: ToDoInfoRepository
) : ViewModel() {
    private var parentJob = Job()
    private val mainCoroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Main
    private val scope = CoroutineScope(mainCoroutineContext)
    
    var todos: LiveData<List<ToDoInfo>> = MutableLiveData()

    init {
        readAll()
    }

    private fun readAll() = scope.launch(Dispatchers.IO) {
        repository.getAll().subscribeBy(
                onSuccess = {
                    todos = MutableLiveData(it)
                },
                onError = {
                    todos
                }
        )
    }

    override fun onCleared() {
        super.onCleared()
        parentJob.cancel()
    }
}
