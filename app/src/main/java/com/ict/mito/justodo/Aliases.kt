package com.ict.mito.justodo

import com.ict.mito.justodo.state.ToDoState
import me.retty.reduxkt.ActionCreator
import me.retty.reduxkt.AsyncActionCreator
import me.retty.reduxkt.Middleware
import me.retty.reduxkt.Reducer
import me.retty.reduxkt.StateSubscriber

typealias Subscriber = StateSubscriber<ToDoState>
typealias AsyncActionCreator = AsyncActionCreator<ToDoState>
typealias ActionCreator = ActionCreator<ToDoState>
typealias Reducer = Reducer<ToDoState>
typealias Middleware = Middleware<ToDoState>