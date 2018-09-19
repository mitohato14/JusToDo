package com.ict.mito.justodo

import androidx.fragment.app.Fragment
import dagger.android.DispatchingAndroidInjector

/**
 * Created by mito on 2018/09/19.
 */
interface HasDispatchFragmentInjector {
    fun dispatchingFragmentInjector(): DispatchingAndroidInjector<Fragment>
}
