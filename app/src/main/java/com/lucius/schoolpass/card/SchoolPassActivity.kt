package com.lucius.schoolpass.card

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.lucius.schoolpass.R

class SchoolPassActivity : AppCompatActivity() {
    private var mSchoolPassFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_school_pass)

        mSchoolPassFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
        mSchoolPassFragment ?: run {
            mSchoolPassFragment = initFragment()
            mSchoolPassFragment?.let {
                supportFragmentManager.beginTransaction().add(R.id.fragment_container, it).commit()
            }
        }
    }

    private fun initFragment(): Fragment {
        return SchoolPassCardFragment.newInstance("", "")
    }

    companion object {
        fun startActivity(context: Context?) {
            context?.let {
                it.startActivity(Intent(it, SchoolPassActivity::class.java))
            }
        }
    }
}