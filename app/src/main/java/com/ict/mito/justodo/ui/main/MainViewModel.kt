package com.ict.mito.justodo.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ict.mito.justodo.domain.ToDoInfo
import com.ict.mito.justodo.domain.repository.ToDoInfoRepository

/**
 * Created by mito on 2018/09/04.
 */
class MainViewModel(repository: ToDoInfoRepository) : ViewModel() {
    var todos: LiveData<List<ToDoInfo>>? = null
        get() {
            if (field == null) {
                field = MutableLiveData<List<ToDoInfo>>()
            }
            return field
        }
}
