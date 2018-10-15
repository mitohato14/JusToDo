package com.ict.mito.justodo.domain.livedata

import androidx.lifecycle.MutableLiveData
import com.ict.mito.justodo.ui.ToDoBindingModel

/**
 * Created by mito on 2018/10/12.
 */
class BindingModelLiveData : MutableLiveData<ToDoBindingModel>() {
    override fun onActive() {
        super.onActive()
        value = ToDoBindingModel(
                title = "",
                date = null,
                description = ""
        )
    }
}