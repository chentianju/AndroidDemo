package com.example.lagoudemo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_second.*

/**
 * 功能：
 **/
class SecondActicity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        secondButton.setOnClickListener {
            startActivity(Intent(this,ThirdActivity::class.java))
        }
    }
}