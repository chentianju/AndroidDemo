package com.example.lagoudemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onclick.setOnClickListener {
            val intent = Intent(this,TouchEventActivity::class.java)
            intent.putExtra("bean",Bean())
            startActivity(intent)
        }
    }
    class Bean:Serializable{
        @Transient
         var data = ByteArray(1024*1024)
    }
}