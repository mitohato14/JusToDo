package com.ict.mito.justodo.ui.todo.list

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.ict.mito.justodo.R
import com.ict.mito.justodo.databinding.TodoListFragmentBinding
import com.ict.mito.justodo.view.ToDoInfoAdapter
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class ToDoListFragment : Fragment() {

    @Inject
    lateinit var toDoListViewModelFactoryProvider: ToDoListViewModelFactory.Provider

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val factory = toDoListViewModelFactoryProvider.provide()
        val viewModel = ViewModelProviders.of(
                this,
                factory
        ).get(ToDOListViewModel::class.java)

        val binding: TodoListFragmentBinding =
                DataBindingUtil.inflate(
                        inflater,
                        R.layout.todo_list__fragment,
                        container,
                        false
                )

        binding.also { it ->
            it.adapter = ToDoInfoAdapter(viewModel.todos)
            it.setAddOnClick {
                it.findNavController().navigate(R.id.action_mainFragment_to_addFragment)
            }
            it.setLifecycleOwner(this)
        }
        return binding.root
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }
}
