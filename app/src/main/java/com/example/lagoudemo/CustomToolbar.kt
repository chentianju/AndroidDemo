package com.example.lagoudemo

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.TypedValue
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView

/**
 * 功能：
 **/
class CustomToolbar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) :
    RelativeLayout(context, attrs, defStyleAttr) {
    private var leftImg: ImageView? = null
    private var title: TextView? = null
    private var rightImg: ImageView? = null

    private var titleStr: String? = null
    private var titleColor = Color.BLACK
    private var leftSrcInt: Drawable? = null
    private var rightInt: Drawable? = null

    init {
        leftImg = ImageView(context)
        rightImg = ImageView(context)
        title = TextView(context)
        attrs?.let {
            getAttrs(context, attrs)
            initView()
        }

    }

    private fun getAttrs(context: Context, attrs: AttributeSet?) {
        val typeArray = context.obtainStyledAttributes(attrs, R.styleable.CustomToolbar)
        titleStr = typeArray.getString(R.styleable.CustomToolbar_title_text)
        titleColor = typeArray.getColor(R.styleable.CustomToolbar_title_text_color, Color.BLACK)
        leftSrcInt = typeArray.getDrawable(R.styleable.CustomToolbar_leftImgSrc)
        rightInt = typeArray.getDrawable(R.styleable.CustomToolbar_rightImgSrc)
        typeArray.recycle()

    }

    private fun initView() {
        leftImg?.setImageDrawable(leftSrcInt)
        rightImg?.setImageDrawable(rightInt)
        title?.text = titleStr
        title?.setTextColor(titleColor)


        val leftParams = LayoutParams(
            TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                48f,
                resources.displayMetrics
            ).toInt(), TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 48f, resources.displayMetrics).toInt()
        )
        leftParams.addRule(ALIGN_PARENT_LEFT, TRUE)
        addView(leftImg,leftParams)

        val titleParams = LayoutParams(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,48f,resources.displayMetrics).toInt(),TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,48f,resources.displayMetrics).toInt())
        titleParams.addRule(CENTER_IN_PARENT, TRUE)
        addView(title,titleParams)

        val rightParams = LayoutParams(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,48f,resources.displayMetrics).toInt(),TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,48f,resources.displayMetrics).toInt())
        rightParams.addRule(ALIGN_PARENT_RIGHT, TRUE)
        addView(rightImg,rightParams)
    }


}