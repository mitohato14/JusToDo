package com.ict.mito.justodo.ui.add

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ict.mito.justodo.R

class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_activity)
        findOrCreateViewFragment()
    }

    private fun findOrCreateViewFragment(): AddFragment {
        var addFragment: AddFragment? =
                supportFragmentManager.findFragmentById(R.id.container) as AddFragment?

        if (addFragment == null) {
            addFragment = AddFragment.newInstance()

            val transaction = supportFragmentManager.beginTransaction()
            transaction.add(
                    R.id.container,
                    addFragment
            )
            transaction.commit()
        }

        return addFragment
    }
}
