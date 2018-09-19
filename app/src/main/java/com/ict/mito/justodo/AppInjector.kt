package com.ict.mito.justodo

import androidx.fragment.app.Fragment
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject

/**
 * Created by mito on 2018/09/19.
 */
class AppInjector : HasDispatchFragmentInjector {
    @Inject
    lateinit var supportFragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun dispatchingFragmentInjector(): DispatchingAndroidInjector<Fragment> =
            supportFragmentInjector
}
