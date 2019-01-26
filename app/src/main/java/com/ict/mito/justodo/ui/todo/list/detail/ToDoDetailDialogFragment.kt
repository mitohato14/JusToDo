package com.ict.mito.justodo.ui.todo.list.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProviders
import com.ict.mito.justodo.R
import com.ict.mito.justodo.databinding.TodoDialogFragmentBinding
import javax.inject.Inject

/**
 * Created by mito on 2018-12-15.
 */
class ToDoDetailDialogFragment : DialogFragment() {
    @Inject
    lateinit var todoDetailViewModelProvider: ToDoDetailViewModelFactory.Provider

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val args = arguments ?: return null
        val safeArgs = ToDoDetailDialogFragmentArgs.fromBundle(args)

        val factory = todoDetailViewModelProvider.provide()
        val viewmodel = ViewModelProviders.of(
                this,
                factory
        ).get(ToDoDetailViewModel::class.java)

        viewmodel.id = safeArgs.toDoId

        val binding: TodoDialogFragmentBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.todo_dialog_fragment,
                container,
                false
        )
        binding.also {
            it.viewmodel = viewmodel
            it.setLifecycleOwner(this)
        }

        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }
}