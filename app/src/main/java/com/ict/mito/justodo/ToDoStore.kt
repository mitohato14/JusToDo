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

    fun getState() = this.store.state

    fun subscribe(subscriber: Subscriber) = this.store.subscribe(subscriber)
    fun unsubscribe(subscriber: Subscriber) = this.store.unsubscribe(subscriber)
}