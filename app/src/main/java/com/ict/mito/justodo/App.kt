package com.ict.mito.justodo

import android.app.Application
import com.github.rozag.redux.base.ReduxSubscribableStore
import com.github.rozag.redux.base.SubscribableStore
import com.ict.mito.justodo.action.ToDoAction
import com.ict.mito.justodo.reducer.rootReducer
import com.ict.mito.justodo.state.ToDoState

/**
 * Created by mito on 2018/07/30.
 */
typealias ToDoStore = ReduxSubscribableStore<ToDoState, ToDoAction>
class App : Application() {

    companion object {
        val store: ToDoStore = SubscribableStore(
                ToDoState.INITIAL,
                ::rootReducer
        )
    }

    override fun onCreate() {
        super.onCreate()
        store.dispatch(ToDoAction.InitToDo())
    }
}
