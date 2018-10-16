package com.ict.mito.justodo.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ict.mito.justodo.domain.ToDoInfo
import com.ict.mito.justodo.domain.repository.ToDoInfoRepository
import io.reactivex.rxkotlin.subscribeBy

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

    private fun readAll() {
        repository.getAll().subscribeBy(
                onSuccess = {
                    todos?.value = it
                },
                onError = {
                    TODO("エラーハンドリング")
                }
        )
    }
}
