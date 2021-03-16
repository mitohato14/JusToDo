package com.ict.mito.justodo.ui.todo.list

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.SimpleItemAnimator
import com.ict.mito.justodo.R
import com.ict.mito.justodo.databinding.TodoListFragmentBinding
import com.ict.mito.justodo.ui.todo.add.AddActivity
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class ToDoListFragment : Fragment() {

  @Inject
  lateinit var toDoListViewModelFactoryProvider: ToDoListViewModelFactory.Provider

  private var binding: TodoListFragmentBinding? = null
  private val viewmodel: ToDoListViewModel by lazy {
    ViewModelProvider(
      this,
      toDoListViewModelFactoryProvider.provide()
    ).get(ToDoListViewModel::class.java)
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = DataBindingUtil.inflate(
      inflater,
      R.layout.todo_list_fragment,
      container,
      false
    )

    viewmodel.also {
      it.adapter.recyclerView = binding?.recycler
      it.todoList.observe(
        viewLifecycleOwner,
        Observer { todoInfoList ->
          it.adapter.setToDoListData(todoInfoList)
        }
      )
      it.startAddView.observe(
        viewLifecycleOwner,
        Observer { start ->
          if (start) {
            activity?.startActivity(
              Intent(
                activity,
                AddActivity::class.java
              )
            )
            it.startedActivity()
          }
        }
      )
    }

    binding?.let {
      it.recycler.setHasFixedSize(true)
      (it.recycler.itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false
      it.viewmodel = viewmodel
      it.lifecycleOwner = this
    }
    return binding?.root
  }

  override fun onResume() {
    super.onResume()
    viewmodel.updateAdapterValue()
    binding?.notifyChange()

    val appCompatActivity = activity as AppCompatActivity?
    appCompatActivity?.supportActionBar?.let {
      it.title = getString(R.string.app_name)
      it.setDisplayHomeAsUpEnabled(false)
      it.setHomeButtonEnabled(false)
    }
  }

  override fun onCreateOptionsMenu(
    menu: Menu,
    inflater: MenuInflater
  ) {
    inflater.inflate(
      R.menu.menu_default,
      menu
    )
  }

  override fun onAttach(context: Context) {
    super.onAttach(context)
    AndroidSupportInjection.inject(this)
  }

  override fun onDestroy() {
    super.onDestroy()
    binding = null
  }
}
