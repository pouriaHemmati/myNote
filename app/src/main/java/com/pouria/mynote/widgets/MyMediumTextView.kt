package com.pouria.mynote.widgets

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet

import androidx.appcompat.widget.AppCompatTextView
import com.pouria.note.R


class MyMediumTextView : AppCompatTextView {
    constructor(context: Context?) : super(context!!) {
        customize()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context!!, attrs) {
        customize()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(
        context!!,
        attrs,
        defStyle
    ) {
        customize()
    }

    private fun customize() {
        val typeface =
            Typeface.createFromAsset(context.assets, context.getString(R.string.fontMedium))
        this.setTypeface(typeface)
    }
}