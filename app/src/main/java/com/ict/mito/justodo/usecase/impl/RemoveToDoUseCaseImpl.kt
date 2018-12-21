package com.ict.mito.justodo.usecase.impl

import com.ict.mito.justodo.domain.ToDoId
import com.ict.mito.justodo.domain.repository.ToDoInfoRepository
import com.ict.mito.justodo.usecase.RemoveToDoUseCase
import io.reactivex.Completable
import javax.inject.Inject

/**
 * Created by mito on 2018/10/03.
 */
class RemoveToDoUseCaseImpl @Inject constructor(
    private val repository: ToDoInfoRepository
) : RemoveToDoUseCase {
    override fun execute(id: Long): Completable = repository.remove(id)
}