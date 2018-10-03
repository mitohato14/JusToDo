package com.ict.mito.justodo.model

import androidx.lifecycle.MutableLiveData

/**
 * Created by mito on 2018/10/03.
 */
class ToDoInfoLiveData : MutableLiveData<ToDoInfo>() {
    override fun onActive() {
        super.onActive()
        value = ToDoInfo()
    }
}