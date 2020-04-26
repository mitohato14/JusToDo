package com.ict.mito.justodo.ui.todo.add

import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by mitohato14 on 2020/04/26.
 */
@Module
abstract class AddActivityModule {
    @ContributesAndroidInjector
    abstract fun addFragment(): AddFragment
}
