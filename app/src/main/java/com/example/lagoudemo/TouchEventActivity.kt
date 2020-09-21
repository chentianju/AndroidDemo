package com.example.lagoudemo

import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.custom_view1.*

/**
 * 功能：
 **/
class TouchEventActivity:AppCompatActivity() {
    companion object{
        val TAG = "TouchEventActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.custom_view1)
        pieImg.setProgress(20)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.i(TAG, "onTouchEvent: "+event)
        return super.onTouchEvent(event)
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        Log.i(TAG, "dispatchTouchEvent: "+ev)
        return super.dispatchTouchEvent(ev)
    }
}