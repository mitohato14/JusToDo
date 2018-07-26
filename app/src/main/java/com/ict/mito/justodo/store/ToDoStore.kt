package com.ict.mito.justodo.store

import com.ict.mito.justodo.reducer.ToDoReducer
import com.ict.mito.justodo.state.ToDoState
import info.izumin.android.droidux.BaseStore
import info.izumin.android.droidux.annotation.Store
import io.reactivex.Flowable

/**
 * Created by mito on 2018/07/16.
 */
@Store(ToDoReducer::class)
interface ToDoStore : BaseStore {
    fun getState(): ToDoState
    fun observeState(): Flowable<ToDoState>
}
