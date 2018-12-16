package com.ict.mito.justodo.ui.main

import com.ict.mito.justodo.ui.todo.add.AddFragment
import com.ict.mito.justodo.ui.todo.list.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by mito on 2018/09/21.
 */
@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector
    abstract fun mainFragment(): MainFragment

    @ContributesAndroidInjector
    abstract fun addFragment(): AddFragment
}
