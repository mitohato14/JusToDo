package com.ict.mito.justodo.ui.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.github.rozag.redux.base.ReduxSubscribableStore
import com.ict.mito.justodo.App
import com.ict.mito.justodo.R
import com.ict.mito.justodo.ToDoStore
import com.ict.mito.justodo.action.ToDoAction
import com.ict.mito.justodo.databinding.AddFragmentBinding
import com.ict.mito.justodo.model.ToDoInfo
import com.ict.mito.justodo.state.ToDoState

class AddFragment : Fragment(), ReduxSubscribableStore.Subscriber<ToDoState> {
    private var todoInfo: ToDoInfo = ToDoInfo()

    override fun onNewState(state: ToDoState) {
    }

    private val store: ToDoStore = App.store
    private lateinit var subscription: ReduxSubscribableStore.Subscription

    companion object {
        fun newInstance() = AddFragment()
    }

    private var binding: AddFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(
                R.layout.add_fragment,
                container,
                false
        )
        binding = DataBindingUtil.bind(view)
        setupView()

        return view
    }

    private fun setupView() {
        binding?.let {
            it.todoInfo = todoInfo
            it.setAddOnClick {
                store.dispatch(ToDoAction.AddToDo(todoInfo))
                fragmentManager?.popBackStack()
                activity?.finish()
            }
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
