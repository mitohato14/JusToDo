package com.ict.mito.justodo

import com.github.rozag.redux.base.ReduxSubscribableStore
import com.ict.mito.justodo.action.ToDoAction
import com.ict.mito.justodo.state.ToDoState

/**
 * Created by mito on 2018/07/29.
 */

typealias ToDoStore = ReduxSubscribableStore<ToDoState, ToDoAction>
