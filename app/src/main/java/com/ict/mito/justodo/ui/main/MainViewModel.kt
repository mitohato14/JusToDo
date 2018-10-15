package com.ict.mito.justodo.ui.main

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ict.mito.justodo.domain.ToDoInfo
import com.ict.mito.justodo.domain.repository.ToDoInfoRepository

/**
 * Created by mito on 2018/09/04.
 */
class MainViewModel(
        private val repository: ToDoInfoRepository
) : ViewModel() {
    var todos: MutableLiveData<List<ToDoInfo>>? = null
        get() {
            if (field == null) {
                field = MutableLiveData()
                readAll()
            }
            return field
        }
    
    @SuppressLint("CheckResult")
    fun readAll() {
        repository.getAll().subscribe { it ->
            todos?.value = it
        }
        
    }
}
