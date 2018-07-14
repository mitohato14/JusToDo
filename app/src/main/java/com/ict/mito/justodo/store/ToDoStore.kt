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

    fun getState(): ToDoState = this.store.state

    fun subscribe(subscriber: Subscriber) = this.store.subscribe(subscriber)
    fun unsubscribe(subscriber: Subscriber) = this.store.unsubscribe(subscriber)

    fun dispatch(action: Action) = this.store.dispatch(action)
    fun dispatch(actionCreator: ActionCreator) = this.store.dispatch(actionCreator)
    fun dispatch(actionCreator: AsyncActionCreator) = this.store.dispatch(actionCreator)
    fun dispatch(
        actionCreator: AsyncActionCreator,
        callback: (ToDoState) -> Unit
    ) = this.store.dispatch(
            actionCreator,
            callback
    )
}
