package com.example.lagoudemo

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

/**
 * 功能：
 **/
class PieImageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val mArcPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val mCirPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val mBound: RectF = RectF()
    private var mProgress = 0
    private val MAX_PROFRESS = 100

    init {
        mArcPaint.run {
            style = Paint.Style.FILL_AND_STROKE
            strokeWidth = 0.1f
            setColor(Color.RED)
        }

        mCirPaint.run {
            style = Paint.Style.STROKE
            strokeWidth = 2f
            setColor(Color.argb(120, 0Xff, 0xFF, 0xFF))
        }
    }

    fun setProgress(mProgress: Int) {
        this.mProgress = mProgress
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (mProgress != MAX_PROFRESS && mProgress != 0) {
            val mAngle = mProgress * 360f / MAX_PROFRESS
            canvas?.drawArc(mBound, 270f, mAngle, true, mArcPaint)
            canvas?.drawCircle(
                mBound.centerX(),
                mBound.centerY(),
                mBound.height() / 2,
                mCirPaint
            )

        }
    }

//    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
//        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
//        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
//        if (MeasureSpec.AT_MOST==widthMode||MeasureSpec.AT_MOST == heightMode){
//            val measureWidth = MeasureSpec.getSize(widthMeasureSpec)
//            val measureHeight = MeasureSpec.getSize(heightMeasureSpec)
//            val size =if (measureWidth>measureHeight) measureHeight else measureWidth
//            setMeasuredDimension(size, size)
//        }
//
//    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        val min =Math.min(w, h)
        val max = w+h-min
        val r = Math.min(w, h)/3
        mBound[(max shr 1) - r.toFloat(), (min shr 1) - r.toFloat(), (max shr 1) + r.toFloat()] =
            (min shr 1) + r.toFloat()
    }

}