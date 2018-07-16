package com.ict.mito.justodo.ui.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.ict.mito.justodo.R
import com.ict.mito.justodo.databinding.AddFragmentBinding
import com.ict.mito.justodo.model.ToDoInfo
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class AddFragment : Fragment() {

    companion object {
        fun newInstance() = AddFragment()
    }

    private var binding: AddFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(
                R.layout.add_fragment,
                container,
                false
        )
        binding = DataBindingUtil.bind(view)
        setupView()

        return view
    }

    private fun setupView() {
        binding?.let {
            val stringFormat = SimpleDateFormat(
                    "MM/dd(E)",
                    Locale.JAPAN
            )
            it.dateString = stringFormat.format(Calendar.getInstance().time)
            it.setAddOnClick {
                val toDoInfo = ToDoInfo(
                        id = "",
                        title = binding?.title ?: "",
                        description = binding?.description ?: "",
                        dueData = "0", // 残り期日を計算して
                        deadline = 0, // binding.dateStringをフォーマットに合わせて変換して
                        completed = false
                )
                fragmentManager?.popBackStack()
                activity?.finish()
            }
        }
    }
}
