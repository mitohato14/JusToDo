package com.ict.mito.justodo.ui.add

import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by mito on 2018/09/20.
 */
@Module
abstract class AddFragmentModule {
    @ContributesAndroidInjector
    abstract fun addFragment(): AddFragment
}
