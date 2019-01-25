package com.ict.mito.justodo.ui.todo.list.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ict.mito.justodo.domain.ToDoInfo
import com.ict.mito.justodo.domain.repository.ToDoInfoRepository
import io.reactivex.rxkotlin.subscribeBy
import java.sql.Date

/**
 * Created by mitohato14 on 2019-01-23.
 */
class ToDoDetailViewModel(private val repository: ToDoInfoRepository) : ViewModel() {
    lateinit var todo: LiveData<ToDoInfo>
    lateinit var dateString: String
    
    var id: Long = -1L
        set(value) {
            repository.getById(value).subscribeBy (
                    onSuccess = {
                        todo = MutableLiveData(it)
                    },
                    onError = {
                        todo
                    }
            )
            dateString = Date(todo.value?.deadlineDate ?: System.currentTimeMillis()).toString()
            field = value
    }
}