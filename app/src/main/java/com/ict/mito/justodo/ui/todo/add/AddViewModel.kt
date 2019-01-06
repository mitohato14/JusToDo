package com.ict.mito.justodo.ui.todo.add

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.ict.mito.justodo.R
import com.ict.mito.justodo.domain.livedata.ToDoInfoLiveDataFactory
import com.ict.mito.justodo.domain.repository.ToDoInfoRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.sql.Date
import kotlin.coroutines.CoroutineContext

/**
 * Created by mito on 2018/09/04.
 */
class AddViewModel(
    private val repository: ToDoInfoRepository,
    todoInfoLiveDataFactory: ToDoInfoLiveDataFactory
) : ViewModel() {
    val todoInfoLiveData = todoInfoLiveDataFactory.create()

    private var parentJob = Job()
    private val mainCoroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Main
    private val scope = CoroutineScope(mainCoroutineContext)

    lateinit var navController: NavController

    private var date: Date? = null

    var addable: Boolean = false
        get() = date != null

    fun onTitleChanged(
        c: CharSequence,
        start: Int,
        before: Int,
        count: Int
    ) {
        todoInfoLiveData.value?.title = c.toString()
    }

    fun onDescriptionChanged(
        c: CharSequence,
        start: Int,
        before: Int,
        count: Int
    ) {
        todoInfoLiveData.value?.description = c.toString()
    }

    fun onClickAddToDoInfo(view: View) {
        todoInfoLiveData.value?.let {
            scope.launch(Dispatchers.IO) {
                repository.add(it)
            }
        }
        navController.navigate(R.id.action_addFragment_to_mainFragment)
    }

    fun onDateChanged(date: java.util.Date) {
        this.date = convertDateToSql(date)
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
