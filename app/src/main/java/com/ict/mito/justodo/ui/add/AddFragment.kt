package com.ict.mito.justodo.ui.add

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.ict.mito.justodo.databinding.AddFragmentBinding
import com.ict.mito.justodo.model.ToDoId
import com.ict.mito.justodo.model.ToDoInfo
import dagger.android.support.AndroidSupportInjection
import java.util.Date
import javax.inject.Inject

class AddFragment : Fragment() {
    private lateinit var binding: AddFragmentBinding
    private lateinit var viewModel: AddViewModel

    @Inject
    lateinit var todoViewModelProvider: AddViewModelFactory.Provider

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AddFragmentBinding.inflate(
                inflater,
                container,
                false
        )

        val factory = todoViewModelProvider.provide()
        viewModel = ViewModelProviders.of(
                this,
                factory
        ).get(AddViewModel::class.java)

        setupView()

        return binding.root
    }

    private fun setupView() {
        binding.also { it ->
            it.viewmodel = viewModel
            it.setAddOnClick { _ ->
                setAddClick(it)
            }
            it.setLifecycleOwner(this)
        }
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
        val toDoInfo = ToDoInfo(
                id = ToDoId("1"),
                title = it.todoTitle.text.toString(),
                description = it.todoDescription.text.toString(),
                dueData = (it.datePicker.date.time - Date().time).toString(),
                deadline = it.datePicker.date.time.toString(),
                completed = false
        )
//        TODO: Add todo
        fragmentManager?.popBackStack()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }
}
