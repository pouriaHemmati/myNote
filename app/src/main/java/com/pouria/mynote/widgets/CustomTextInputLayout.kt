package com.pouria.mynote.widgets

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.EditText
import com.google.android.material.textfield.TextInputLayout
import com.pouria.note.R

class CustomTextInputLayout : TextInputLayout {
    var font = Typeface.createFromAsset(context.assets, context.getString(R.string.fontMedium))

    constructor(context: Context?) : super(context!!) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(
        context!!, attrs
    ) {
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context!!, attrs, defStyleAttr
    ) {
    }

    override fun addView(child: View, index: Int, params: ViewGroup.LayoutParams) {
        super.addView(child, index, params)
        if (child is EditText) {
            // Typeface is set when adding an EditText, so we must set ours after
            typeface = font
        }
    }

    override fun setError(errorText: CharSequence?) {
        super.setError(errorText)
        val font = Typeface.createFromAsset(context.assets, context.getString(R.string.fontMedium))
        typeface = font
        setErrorTextColor(ColorStateList.valueOf(context.resources.getColor(R.color.error)))
        if (errorText != null) {
            val animation = AnimationUtils.loadAnimation(context, R.anim.shake)
            startAnimation(animation)
        }
    }
}