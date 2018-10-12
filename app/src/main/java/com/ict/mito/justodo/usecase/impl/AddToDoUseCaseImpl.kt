package com.ict.mito.justodo.usecase.impl

import com.ict.mito.justodo.domain.ToDoInfo
import com.ict.mito.justodo.domain.repository.ToDoInfoRepository
import com.ict.mito.justodo.usecase.AddToDoUseCase
import io.reactivex.Completable
import javax.inject.Inject

/**
 * Created by mito on 2018/10/03.
 */
class AddToDoUseCaseImpl @Inject constructor(
    private val repository: ToDoInfoRepository
) : AddToDoUseCase {
    override fun execute(todo: ToDoInfo): Completable =
            Completable.create { repository.add(todo) }
}