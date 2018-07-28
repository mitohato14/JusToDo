package com.ict.mito.justodo.module

import android.app.Application
import com.ict.mito.justodo.store.ToDoStore

/**
 * Created by mito on 2018/07/26.
 */
class App : Application() {
    companion object {
        const val tag: String = "App"
    }

    private lateinit var store: ToDoStore

    fun getStore() = store

    override fun onCreate() {
        super.onCreate()
        setupStore()
    }

    fun setupStore() {

//        store = DroiduxToDoStore.builder()
    }
}
