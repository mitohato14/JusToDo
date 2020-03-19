package com.ict.mito.justodo.ui.todo.add

import android.view.View
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.ict.mito.justodo.R
import com.ict.mito.justodo.domain.livedata.ToDoInfoLiveDataFactory
import com.ict.mito.justodo.domain.repository.ToDoInfoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.sql.Date
import java.util.Calendar

/**
 * Created by mito on 2018/09/04.
 */
class AddViewModel(
    private val repository: ToDoInfoRepository,
    todoInfoLiveDataFactory: ToDoInfoLiveDataFactory
) : ViewModel() {
    val todoInfoLiveData = todoInfoLiveDataFactory.create()

    lateinit var navController: NavController

    var addable: MediatorLiveData<Boolean> = MediatorLiveData()

    private var dateTime: MutableLiveData<Long> = MutableLiveData(-1L)

    init {
        addable.addSource(dateTime) {
            addable.value = dateTime.value != -1L
        }
    }

    fun onClickAddToDoInfo(view: View) {
        todoInfoLiveData.value?.let {
            it.dueDate = (
                (it.deadlineDate - System.currentTimeMillis()) / (1000 * 60 * 60 * 24)
                ).toString()
            viewModelScope.launch(Dispatchers.IO) {
                repository.add(it)
            }
        }
        navController.navigate(R.id.action_addFragment_to_toDoListFragment)
    }

    fun onDateChanged(date: java.util.Date) {
        dateTime.value = convertDateToSql(date).time
        todoInfoLiveData.value?.deadlineDate = dateTime.value ?: -1L
    }

    private fun convertDateToSql(utilDate: java.util.Date): Date {
        val cal = Calendar.getInstance()
        cal.also {
            it.time = utilDate
            it.set(
                Calendar.HOUR_OF_DAY,
                0
            )
            it.set(
                Calendar.MINUTE,
                0
            )
            it.set(
                Calendar.SECOND,
                0
            )
            it.set(
                Calendar.MILLISECOND,
                0
            )
        }

        return Date(cal.timeInMillis)
    }
}
