package com.ict.mito.justodo.ui.add

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ict.mito.justodo.R

class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(
                            R.id.container,
                            AddFragment.newInstance()
                    )
                    .commitNow()
        }
    }
}
