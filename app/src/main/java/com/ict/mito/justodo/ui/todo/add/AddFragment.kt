package com.ict.mito.justodo.ui.todo.add

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.ict.mito.justodo.R
import com.ict.mito.justodo.databinding.AddFragmentBinding
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class AddFragment : Fragment() {

    @Inject
    lateinit var todoViewModelProvider: AddViewModelFactory.Provider

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val factory = todoViewModelProvider.provide()
        val viewModel = ViewModelProviders.of(
                this,
                factory
        ).get(AddViewModel::class.java)

        val binding: AddFragmentBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.add_fragment,
                container,
                false
        )

        binding.also { it ->
            it.viewmodel = viewModel
            it.setAddOnClick {
                setAddClick(binding)
            }
            it.setLifecycleOwner(this)
        }

        return binding.root
    }

    private fun setAddClick(it: AddFragmentBinding) {
        if (it.datePicker.date == null) {
            Toast.makeText(
                    context,
                    "Please write date",
                    Toast.LENGTH_SHORT
            ).show()
            return
        }
//        val toDoInfo = ToDoInfo(
//                id = ToDoId(UUID.randomUUID().toString()),
//                title = it.todoTitle.text.toString(),
//                description = it.todoDescription.text.toString(),
//                dueData = (it.datePicker.date.time - Date().time).toString(),
//                deadline = it.datePicker.date.time.toString(),
//                completed = false
//        )
//        TODO: Add todo
        fragmentManager?.popBackStack()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }
}
