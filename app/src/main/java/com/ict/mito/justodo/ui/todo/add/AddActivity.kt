package com.ict.mito.justodo.ui.todo.add

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ict.mito.justodo.R
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.android.synthetic.main.add_activity.*
import javax.inject.Inject

class AddActivity : AppCompatActivity(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_activity)

        setSupportActionBar(toolbar)
    }
}
