package com.ict.mito.justodo.store

import com.ict.mito.justodo.ActionCreator
import com.ict.mito.justodo.AsyncActionCreator
import com.ict.mito.justodo.Subscriber
import com.ict.mito.justodo.reducer.RootReducerSet
import com.ict.mito.justodo.state.ToDoState
import me.retty.reduxkt.Action
import me.retty.reduxkt.Store

object ToDoStore {

    private val store: Store<ToDoState> by lazy {
        Store(
                getInitialState(),
                RootReducerSet.aggregatedReducer,
                listOf()
        )
    }

    private fun getInitialState(): ToDoState {
        return ToDoState()
    }

    fun getState() = store.state

    fun subscribe(subscriber: Subscriber) = store.subscribe(subscriber)
    fun unsubscribe(subscriber: Subscriber) = store.unsubscribe(subscriber)

    fun dispatch(action: Action) = store.dispatch(action)
    fun dispatch(actionCreator: ActionCreator) = store.dispatch(actionCreator)
    fun dispatch(actionCreator: AsyncActionCreator) = store.dispatch(actionCreator)
    fun dispatch(
            actionCreator: AsyncActionCreator,
            callback: (ToDoState) -> Unit
    ) = store.dispatch(
            actionCreator,
            callback
    )
}