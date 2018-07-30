package com.ict.mito.justodo.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ict.mito.justodo.R
import com.ict.mito.justodo.ToDoStore
import com.ict.mito.justodo.databinding.MainFragmentBinding
import com.ict.mito.justodo.ui.add.AddActivity
import javax.inject.Inject

class MainFragment : Fragment() {

    @Inject
    lateinit var store: ToDoStore

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(
                R.layout.main_fragment,
                container,
                false
        )

        val binding: MainFragmentBinding? = DataBindingUtil.bind(view)
        binding?.let {
            it.layoutManager = LinearLayoutManager(this.context?.applicationContext)
            it.setAddOnClick {
                AddActivity.start(this@MainFragment.context)
            }
        }

        return view
    }
}
