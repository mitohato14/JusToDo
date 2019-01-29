package com.ict.mito.justodo.ui.todo.list

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.ict.mito.justodo.R
import com.ict.mito.justodo.domain.ToDoInfo
import com.ict.mito.justodo.domain.repository.ToDoInfoRepository
import com.ict.mito.justodo.ui.todo.list.view.ToDoListAdapter
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

    var navController: NavController? = null
        set(value) {
            if (value == null) return
            field = value
            adapter.navController = value
    }

    var todos: LiveData<List<ToDoInfo>> = MutableLiveData()
    val adapter: ToDoListAdapter = ToDoListAdapter(todos.value ?: listOf())

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

    fun updateDueDate() = scope.launch(Dispatchers.IO) {
        repository.getAll().subscribeBy(
                onSuccess = {
                    it.forEach { todo ->
                        todo.dueDate = (
                                (todo.deadlineDate - System.currentTimeMillis())
                                        / (1000 * 60 * 60 * 24)
                                ).toString()
                        scope.launch(Dispatchers.IO) { repository.store(todo) }
                    }
                },
                onError = {
                }
        )
    }

    fun fabOnClick(view: View) {
        navController?.navigate(R.id.action_toDoListFragment_to_addFragment)
    }

    fun updateAdapterValue() {
        updateDueDate()
        readAll()
        todos.value?.let { adapter.setToDoListData(it) }
    }

    override fun onCleared() {
        super.onCleared()
        parentJob.cancel()
    }
}
