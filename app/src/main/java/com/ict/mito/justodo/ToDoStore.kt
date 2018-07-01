package com.ict.mito.justodo

import me.retty.reduxkt.Store

object ToDoStore {

    private val store: Store<ToDoState> by lazy {
        Store(
                getInitialState(),
                RootReducerSet.aggregatedReducer,
                listOf()
        )
    }
    
    private fun getInitialState() : ToDoState {
        return ToDoState()
    }

}