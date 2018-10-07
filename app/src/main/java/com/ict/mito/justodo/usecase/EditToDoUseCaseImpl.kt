package com.ict.mito.justodo.usecase

import com.ict.mito.justodo.model.ToDoId
import com.ict.mito.justodo.repository.ToDoInfoRepository
import io.reactivex.Completable
import javax.inject.Inject

/**
 * Created by mito on 2018/10/03.
 */
class EditToDoUseCaseImpl @Inject constructor(
    repository: ToDoInfoRepository
) : EditToDoUseCase {
    override fun execute(id: ToDoId): Completable {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }
}