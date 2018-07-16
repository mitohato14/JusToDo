package com.ict.mito.justodo.store

import com.ict.mito.justodo.state.ToDoState
import info.izumin.android.droidux.BaseStore
import io.reactivex.Flowable

/**
 * Created by mito on 2018/07/16.
 */
interface ToDoStore : BaseStore{
    fun getState(): ToDoState
    fun observeState(): Flowable<ToDoState>
}