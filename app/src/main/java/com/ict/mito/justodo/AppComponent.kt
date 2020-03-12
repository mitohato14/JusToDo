package com.ict.mito.justodo

import com.ict.mito.justodo.domain.db.DataBaseModule
import com.ict.mito.justodo.repository.RepositoryModule
import com.ict.mito.justodo.ui.ActivityModule
import com.ict.mito.justodo.usecase.UseCaseModule
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton

/**
 * Created by mito on 2018/09/18.
 */
@Singleton
@Component(
    modules = [
        RepositoryModule::class,
        UseCaseModule::class,
        DataBaseModule::class,
        ActivityModule::class
    ]
)
interface AppComponent : AndroidInjector<App>
