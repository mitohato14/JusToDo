package com.ict.mito.justodo.ui.todo.list

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.ict.mito.justodo.R
import com.ict.mito.justodo.databinding.TodoListFragmentBinding
import com.ict.mito.justodo.domain.ToDoInfo
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class ToDoListFragment : Fragment() {

    @Inject
    lateinit var toDoListViewModelFactoryProvider: ToDoListViewModelFactory.Provider

    private lateinit var binding: TodoListFragmentBinding
    private lateinit var viewModel: ToDoListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val factory = toDoListViewModelFactoryProvider.provide()
        viewModel = ViewModelProviders.of(
                this,
                factory
        ).get(ToDoListViewModel::class.java)

        viewModel.also {
            it.todos.observe(
                    this,
                    Observer<List<ToDoInfo>> { todoInfoList ->
                        it.adapter.setToDoListData(todoInfoList)
                    }
            )
            it.navController = findNavController()
        }

        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.todo_list_fragment,
                container,
                false
        )

        binding.also { it ->
            it.viewmodel = viewModel
            it.setLifecycleOwner(this)
        }
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.updateAdapterValue()
        binding.notifyChange()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }
}
