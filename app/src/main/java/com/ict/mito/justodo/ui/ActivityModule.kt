package com.ict.mito.justodo.ui

import com.ict.mito.justodo.ui.main.MainActivity
import com.ict.mito.justodo.ui.main.MainActivityModule
import com.ict.mito.justodo.ui.todo.add.AddActivity
import com.ict.mito.justodo.ui.todo.add.AddActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by mito on 2018/09/21.
 */
@Module
abstract class ActivityModule {
    @ContributesAndroidInjector(
        modules = [
            MainActivityModule::class,
            AddActivityModule::class
        ]
    )
    abstract fun mainActivity(): MainActivity
    abstract fun addActivity(): AddActivity
}
