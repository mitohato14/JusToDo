package com.ict.mito.justodo.ui

import com.ict.mito.justodo.ui.main.MainActivity
import com.ict.mito.justodo.ui.todo.add.AddActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by mito on 2018/09/21.
 */
@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun addActivity(): AddActivity
}
