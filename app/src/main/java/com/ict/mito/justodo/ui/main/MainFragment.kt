package com.ict.mito.justodo.ui.main

import android.content.Context
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
import com.ict.mito.justodo.view.ToDoInfoAdapter
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class MainFragment : Fragment() {

    @Inject
    lateinit var mainViewModelFactoryProvider: MainViewModelFactory.Provider

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val factory = mainViewModelFactoryProvider.provide()
        val viewModel = ViewModelProviders.of(
                this,
                factory
        ).get(MainViewModel::class.java)

        val binding: MainFragmentBinding =
                DataBindingUtil.inflate(
                        inflater,
                        R.layout.main_fragment,
                        container,
                        false
                )

        binding.also { it ->
            it.layoutManager = LinearLayoutManager(this.context?.applicationContext)
            it.adapter = ToDoInfoAdapter(viewModel.todos?.value ?: listOf())
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
