package com.ict.mito.justodo.ui.add

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ict.mito.justodo.model.ToDoInfo
import com.ict.mito.justodo.repository.ToDoInfoRepository
import javax.inject.Inject

/**
 * Created by mito on 2018/09/04.
 */
class AddViewModel @Inject constructor(
        repository: ToDoInfoRepository
) : ViewModel() {
    var todoInfoLiveData: MutableLiveData<ToDoInfo>? = null
        get() {
            if (field == null) {
                field = MutableLiveData()
            }
            return field
        }

    fun onTitleChanged(
        c: CharSequence,
        start: Int,
        before: Int,
        count: Int
    ) {
        todoInfoLiveData?.value?.title = c.toString()
    }

    fun onDescriptionChanged(
        c: CharSequence,
        start: Int,
        before: Int,
        count: Int
    ) {
        todoInfoLiveData?.value?.description = c.toString()
    }
}
