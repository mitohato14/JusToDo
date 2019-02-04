package com.ict.mito.justodo.ui.todo.list.detail

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.ict.mito.justodo.R
import com.ict.mito.justodo.databinding.TodoFragmentBinding
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

/**
 * Created by mito on 2018-12-15.
 */
class ToDoDetailFragment : Fragment() {
    @Inject
    lateinit var todoDetailViewModelProvider: ToDoDetailViewModelFactory.Provider

    lateinit var viewmodel: ToDoDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)

        val args = arguments ?: return null
        val safeArgs = ToDoDetailFragmentArgs.fromBundle(args)

        val factory = todoDetailViewModelProvider.provide()
        viewmodel = ViewModelProviders.of(
                this,
                factory
        ).get(ToDoDetailViewModel::class.java)

        viewmodel.id = safeArgs.toDoId

        val binding: TodoFragmentBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.todo_fragment,
                container,
                false
        )
        binding.also {
            it.viewmodel = viewmodel
            it.lifecycleOwner = this
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        val appCompatActivity = activity as AppCompatActivity?
        appCompatActivity?.supportActionBar?.let {
            it.title = viewmodel.todo.value?.title ?: getString(R.string.no_title)
            it.setDisplayHomeAsUpEnabled(true)
            it.setHomeButtonEnabled(true)
        }
    }

    override fun onCreateOptionsMenu(
        menu: Menu,
        inflater: MenuInflater
    ) {
        inflater.inflate(
                R.menu.menu_detail,
                menu
        )
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {

            R.id.action_done -> {
                if (viewmodel.todo.value?.done == true) {
                    viewmodel.todo.value?.undone()
                } else {
                    viewmodel.todo.value?.done()
                }
                viewmodel.updateToDo()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}