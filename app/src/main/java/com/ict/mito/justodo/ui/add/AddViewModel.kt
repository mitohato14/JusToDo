package com.ict.mito.justodo.ui.add

import androidx.lifecycle.ViewModel
import com.ict.mito.justodo.domain.livedata.ToDoInfoLiveDataFactory
import com.ict.mito.justodo.domain.repository.ToDoInfoRepository

/**
 * Created by mito on 2018/09/04.
 */
class AddViewModel(
        repository: ToDoInfoRepository,
        todoInfoLiveDataFactory: ToDoInfoLiveDataFactory
) : ViewModel() {
    val todoInfoLiveData = todoInfoLiveDataFactory.create()

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
}
