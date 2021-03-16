package com.ict.mito.justodo

import com.ict.mito.justodo.infla.db.DataBaseModule
import com.ict.mito.justodo.infla.repository.module.RepositoryModule
import com.ict.mito.justodo.ui.ActivityModule
import com.ict.mito.justodo.ui.FragmentModule
import com.ict.mito.justodo.ui.main.MainActivity
import com.ict.mito.justodo.ui.todo.add.AddActivity
import com.ict.mito.justodo.usecase.UseCaseModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by mito on 2018/09/18.
 */
@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        RepositoryModule::class,
        UseCaseModule::class,
        DataBaseModule::class,
        ActivityModule::class,
        FragmentModule::class
    ]
)
interface AppComponent {
    fun inject(app: App)
    fun inject(activity: MainActivity)
    fun inject(activity: AddActivity)
}
