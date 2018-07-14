package com.ict.mito.justodo.store

import com.ict.mito.justodo.state.ToDoState

/**
 * Created by mito on 2018/07/14.
 */
object Store {
    val state by lazy {
        ToDoState()
    }
}