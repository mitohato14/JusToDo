package com.ict.mito.justodo.reducer

import com.ict.mito.justodo.action.ToDoAction
import com.ict.mito.justodo.state.ToDoState

class ToDoReducerSet {

    companion object {
        fun aggregatedReducer(action: ToDoAction, state: ToDoState) = state
    }
}