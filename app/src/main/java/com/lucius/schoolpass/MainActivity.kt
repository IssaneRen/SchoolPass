package com.lucius.schoolpass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lucius.schoolpass.card.SchoolPassActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_jump_school_pass?.setOnClickListener {
            SchoolPassActivity.startActivity(this@MainActivity)
        }
    }
}