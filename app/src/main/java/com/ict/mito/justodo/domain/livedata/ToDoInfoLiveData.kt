package com.ict.mito.justodo.domain.livedata

import androidx.lifecycle.LiveData
import com.ict.mito.justodo.domain.ToDoInfo

/**
 * Created by mito on 2018/10/03.
 */
class ToDoInfoLiveData : LiveData<ToDoInfo>() {
    override fun onActive() {
        super.onActive()
        value = ToDoInfo(
            title = "",
            description = "",
            dueDate = "",
            deadlineDate = -1L,
            done = false
        )
    }
}
