package com.ict.mito.justodo.ui.todo.add

import android.view.View
import androidx.lifecycle.ViewModel
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

    var date: Date? = null

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
    }
}
