package com.ict.mito.justodo.ui.add

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.rozag.redux.base.ReduxSubscribableStore
import com.ict.mito.justodo.App
import com.ict.mito.justodo.R
import com.ict.mito.justodo.ToDoStore
import com.ict.mito.justodo.state.ToDoState

class AddActivity : AppCompatActivity(), ReduxSubscribableStore.Subscriber<ToDoState> {
    private val store: ToDoStore = App.store
    private lateinit var subscription: ReduxSubscribableStore.Subscription

    override fun onNewState(state: ToDoState) {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_activity)
        findOrCreateViewFragment()
    }

    private fun findOrCreateViewFragment(): AddFragment {
        var addFragment: AddFragment? =
                supportFragmentManager.findFragmentById(R.id.container) as AddFragment?

        if (addFragment == null) {
            addFragment = AddFragment.newInstance()

            val transaction = supportFragmentManager.beginTransaction()
            transaction.add(
                    R.id.container,
                    addFragment
            )
            transaction.commit()
        }

        return addFragment
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
