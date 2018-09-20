package com.ict.mito.justodo.ui.add

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
import com.ict.mito.justodo.model.GlobalValue
import com.ict.mito.justodo.model.ToDoInfo
import java.util.Date
import javax.inject.Inject

class AddFragment : Fragment() {
    private var binding: AddFragmentBinding? = null
    private lateinit var viewModel: AddViewModel
    
    @Inject
    lateinit var addViewModelFactory: AddViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(
                this,
                addViewModelFactory
        ).get(AddViewModel::class.java)

        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.add_fragment,
                container,
                false
        )
        setupView()

        return binding?.root
    }

    private fun setupView() {
        binding?.let { it ->
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
                id = GlobalValue.toDoInfoList.size.toString(),
                title = it.todoTitle.text.toString(),
                description = it.todoDescription.text.toString(),
                dueData = (it.datePicker.date.time - Date().time).toString(),
                deadline = it.datePicker.date.time.toString(),
                completed = false
        )
        GlobalValue.toDoInfoList.add(toDoInfo)
        fragmentManager?.popBackStack()
    }
}
