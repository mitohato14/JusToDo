package com.ict.mito.justodo.domain.livedata

import androidx.lifecycle.MutableLiveData
import com.ict.mito.justodo.domain.ToDoId
import com.ict.mito.justodo.domain.ToDoInfo

/**
 * Created by mito on 2018/10/03.
 */
class ToDoInfoLiveData : MutableLiveData<ToDoInfo>() {
    override fun onActive() {
        super.onActive()
        value = ToDoInfo(
                id = ToDoId(""),
                title = "",
                description = "",
                dueData = "",
                deadline = "",
                done = false
        )
    }
}