package com.ict.mito.justodo.ui.todo.detail

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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

    private val viewmodel: ToDoDetailViewModel by lazy {
        ViewModelProviders.of(
            this,
            todoDetailViewModelProvider.provide()
        ).get(ToDoDetailViewModel::class.java)
    }

    private var binding: TodoFragmentBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)

        val args = arguments ?: return null
        val safeArgs = ToDoDetailFragmentArgs.fromBundle(args)
        viewmodel.id = safeArgs.toDoId

        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.todo_fragment,
                container,
                false
        )
        binding?.let {
            it.viewmodel = viewmodel
            it.lifecycleOwner = this
        }

        return binding?.root
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_done -> {
                if (viewmodel.todo.value?.done == true) {
                    viewmodel.undone()
                    Toast.makeText(
                        context,
                        "undone",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    viewmodel.done()
                    Toast.makeText(
                        context,
                        "done",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
        return super.onOptionsItemSelected(item)
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
