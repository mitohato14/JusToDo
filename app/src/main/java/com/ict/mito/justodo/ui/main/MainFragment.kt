package com.ict.mito.justodo.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ict.mito.justodo.R
import com.ict.mito.justodo.databinding.MainFragmentBinding
import com.ict.mito.justodo.model.GlobalValue
import com.ict.mito.justodo.view.ToDoInfoAdapter

class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        val binding: MainFragmentBinding? =
                DataBindingUtil.inflate(
                        inflater,
                        R.layout.main_fragment,
                        container,
                        false
                )

        binding?.let { it ->
            it.layoutManager = LinearLayoutManager(this.context?.applicationContext)
            it.adapter = ToDoInfoAdapter(GlobalValue.toDoInfoList)
            it.setAddOnClick {
                it.findNavController().navigate(R.id.action_mainFragment_to_addFragment)
            }
            it.setLifecycleOwner(this)
        }
        return binding?.root
    }
}
