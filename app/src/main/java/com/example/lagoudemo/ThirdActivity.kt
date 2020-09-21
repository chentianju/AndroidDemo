package com.example.lagoudemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

/**
 * 功能：
 **/
class ThirdActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        Log.i("TAG", "onCreate: ")
    }

    override fun onResume() {
        super.onResume()
        Log.i("TAG", "onResume: ")
    }
    override fun onRestart() {
        super.onRestart()
        Log.i("TAG", "onRestart: ")
    }
    override fun onPause() {
        super.onPause()
        Log.i("TAG", "onPause: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("TAG", "onDestroy: ")
    }
}