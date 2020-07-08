package com.sample.rxnaversearchapi.custom

import android.content.Context
import android.graphics.drawable.Drawable
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View.OnTouchListener
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.res.ResourcesCompat
import com.sample.rxnaversearchapi.R

class EditTextWithClear : AppCompatEditText {

    private lateinit var clearDrawable: Drawable
    private lateinit var searchDrawable: Drawable

    constructor(context: Context) : super(context) {
        operateCustom()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        operateCustom()
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        operateCustom()
    }

    private fun operateCustom() {
        setClearIconVisible(false)

        addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                setClearIconVisible(s.isNotEmpty())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

        setOnTouchListener(OnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                if (event.rawX >= (right - compoundPaddingRight)) {
                    text?.clear()
                    return@OnTouchListener true
                }
            }
            return@OnTouchListener false
        })
    }

    private fun setClearIcon() {
        clearDrawable = ResourcesCompat.getDrawable(
            resources,
            R.drawable.ic_clear, null
        )!!
    }

    private fun setSearchIcon() {
        searchDrawable = ResourcesCompat.getDrawable(
            resources,
            R.drawable.ic_search, null
        )!!

    }

    private fun setClearIconVisible(visible: Boolean) {
        setSearchIcon()
        setClearIcon()
        setCompoundDrawablesRelativeWithIntrinsicBounds(
            searchDrawable,
            null,
            if (visible) clearDrawable else null,
            null
        )
    }
}