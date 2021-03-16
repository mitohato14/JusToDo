package com.ict.mito.justodo.ui

import com.ict.mito.justodo.ui.todo.add.AddFragment
import com.ict.mito.justodo.ui.todo.detail.ToDoDetailFragment
import com.ict.mito.justodo.ui.todo.list.ToDoListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by mitohato14 on 2020/04/29.
 */
@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun addFragment(): AddFragment

    @ContributesAndroidInjector
    abstract fun mainFragment(): ToDoListFragment

    @ContributesAndroidInjector
    abstract fun todoDetailFragment(): ToDoDetailFragment
}
