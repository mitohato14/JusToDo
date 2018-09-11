package com.ict.mito.justodo.ui.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.ict.mito.justodo.R
import com.ict.mito.justodo.databinding.AddFragmentBinding
import com.ict.mito.justodo.model.GlobalValue
import com.ict.mito.justodo.model.ToDoInfo

class AddFragment : Fragment() {
    private var binding: AddFragmentBinding? = null
    private lateinit var viewModel: AddViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(this).get(AddViewModel::class.java)
        
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
            it.setAddOnClick {
                GlobalValue.toDoInfoList.add(viewModel.todoInfo?.value ?: ToDoInfo())
                fragmentManager?.popBackStack()
            }
        }
    }
}
