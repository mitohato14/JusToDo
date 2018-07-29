package com.ict.mito.justodo.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.rozag.redux.base.SubscribableStore
import com.ict.mito.justodo.R
import com.ict.mito.justodo.ToDoStore
import com.ict.mito.justodo.action.ToDoAction
import com.ict.mito.justodo.reducer.rootReducer
import com.ict.mito.justodo.state.ToDoState

class MainActivity : AppCompatActivity() {
    companion object {
        val store: ToDoStore = SubscribableStore(
                ToDoState.INITIAL,
                ::rootReducer
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(
                            R.id.container,
                            MainFragment.newInstance()
                    )
                    .commitNow()
        }
        store.dispatch(ToDoAction.InitToDo())
    }
}
