package com.ict.mito.justodo.ui.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.ict.mito.justodo.R
import com.ict.mito.justodo.action.ToDoAction
import com.ict.mito.justodo.databinding.AddFragmentBinding
import com.ict.mito.justodo.model.ToDoInfo
import com.ict.mito.justodo.store.ToDoStore
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.Calendar

class AddFragment : Fragment() {

    companion object {
        fun newInstance() = AddFragment()
    }

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

        val binding: AddFragmentBinding? = DataBindingUtil.bind(view)
        binding?.let {
            val stringFormat = SimpleDateFormat(
                    "MM/dd(E)",
                    Locale.JAPAN
            )
            it.dateString = stringFormat.format(Calendar.getInstance().time)
            it.setAddOnClick {
                val toDoInfo = ToDoInfo(
                        id = "",
                        title = binding.title ?: "",
                        description = binding.description ?: "",
                        dueData = 0, // 残り期日を計算して
                        deadline = 0 // binding.dateStringをフォーマットに合わせて変換して
                )
                ToDoStore.dispatch(ToDoAction.OnCreateToDoAction(toDoInfo))
            }
        }
        return view
    }
}
