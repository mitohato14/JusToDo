package com.ict.mito.justodo.reducer

import com.ict.mito.justodo.state.ToDoState
import me.retty.reduxkt.Reducer

class RootReducerSet {
    companion object {
        val aggregatedReducer: Reducer<ToDoState> = { action, state ->
            when (action) {
            }
        }
    }
}