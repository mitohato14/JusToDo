package com.ict.mito.justodo.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.rozag.redux.base.ReduxSubscribableStore
import com.ict.mito.justodo.App
import com.ict.mito.justodo.R
import com.ict.mito.justodo.ToDoStore
import com.ict.mito.justodo.state.ToDoState

class MainActivity : AppCompatActivity(), ReduxSubscribableStore.Subscriber<ToDoState> {
    private val store: ToDoStore = App.store
    private lateinit var subscription: ReduxSubscribableStore.Subscription

    override fun onNewState(state: ToDoState) {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
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
    }

    override fun onStart() {
        super.onStart()
        subscription = store.subscribe(this)
    }

    override fun onStop() {
        super.onStop()
        subscription.cancel()
    }
}
