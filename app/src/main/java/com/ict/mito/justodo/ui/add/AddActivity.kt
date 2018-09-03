package com.ict.mito.justodo.ui.add

import android.content.Context
import android.content.Intent
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

    companion object {
        fun start(context: Context?) {
            val intent = Intent(
                    context,
                    AddActivity::class.java
            )
            context?.startActivity(intent)
        }
    }
}
