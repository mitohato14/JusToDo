package com.ict.mito.justodo.ui.todo.list

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.ict.mito.justodo.R
import com.ict.mito.justodo.domain.ToDoInfo
import com.ict.mito.justodo.domain.repository.ToDoInfoRepository
import com.ict.mito.justodo.ui.todo.list.view.ToDoListAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by mito on 2018/09/04.
 */
class ToDoListViewModel(
    private val repository: ToDoInfoRepository
) : ViewModel() {

    var navController: NavController? = null
        set(value) {
            if (value == null) return
            field = value
            adapter.navController = value
        }

    val todos: LiveData<List<ToDoInfo>>
        get() = _todos
    private val _todos: MutableLiveData<List<ToDoInfo>> = MutableLiveData()

    val adapter: ToDoListAdapter = ToDoListAdapter(_todos.value ?: listOf())

    init {
        readAll()
    }

    private fun readAll() = viewModelScope.launch(Dispatchers.IO) {
        _todos.value = repository.getAll()
    }

    private fun updateDueDate() = viewModelScope.launch(Dispatchers.IO) {
        repository.getAll().forEach { todo ->
            todo.dueDate = (
                (todo.deadlineDate - System.currentTimeMillis()) / (1000 * 60 * 60 * 24)
                ).toString()
            repository.store(todo)
        }
    }

    fun fabOnClick(view: View) {
        navController?.navigate(R.id.action_toDoListFragment_to_addFragment)
    }

    fun updateAdapterValue() {
        updateDueDate()
        readAll()
        _todos.value?.let { adapter.setToDoListData(it) }
    }
}
