package com.ict.mito.justodo.usecase

import com.ict.mito.justodo.model.ToDoInfo
import com.ict.mito.justodo.repository.ToDoInfoRepository
import io.reactivex.Completable
import javax.inject.Inject

/**
 * Created by mito on 2018/10/03.
 */
class AddToDoUseCaseImpl @Inject constructor(
    repository: ToDoInfoRepository
) : AddToDoUseCase {
    override fun execute(todo: ToDoInfo): Completable {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }
}