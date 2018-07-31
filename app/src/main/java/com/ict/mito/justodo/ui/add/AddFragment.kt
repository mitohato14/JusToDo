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
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class AddFragment : Fragment(), ReduxSubscribableStore.Subscriber<ToDoState> {
    override fun onNewState(state: ToDoState) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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
            val stringFormat = SimpleDateFormat(
                    "MM/dd(E)",
                    Locale.JAPAN
            )
            it.dateString = stringFormat.format(Calendar.getInstance().time)
            it.setAddOnClick {
                val toDoInfo = ToDoInfo(
                        id = "",
                        title = binding?.title ?: "",
                        description = binding?.description ?: "",
                        dueData = "0", // 残り期日を計算して
                        deadline = 0, // binding.dateStringをフォーマットに合わせて変換して
                        completed = false
                )
                store.dispatch(ToDoAction.AddToDo(toDoInfo))
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
