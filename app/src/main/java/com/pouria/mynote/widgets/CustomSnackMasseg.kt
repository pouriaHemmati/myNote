package com.pouria.mynote.widgets

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import com.covid19.base.BaseActivity
import com.google.android.material.snackbar.Snackbar
import com.pouria.note.R


class CustomSnackMasseg {

    companion object {
        @SuppressLint("ShowToast")
        fun showSnack(context: Context, message: String?, view: View) {
            val snkbr: Snackbar = Snackbar
                .make(view, message!!, Snackbar.LENGTH_LONG)
                .setActionTextColor(Color.WHITE)
            val snackBarView: View = snkbr.view
            snackBarView.setBackgroundColor(
                ContextCompat.getColor(
                    BaseActivity.applicationContext(),
                    R.color.snackBarColor
                ))
            ViewCompat.setLayoutDirection(snkbr.view, ViewCompat.LAYOUT_DIRECTION_RTL)
            (snkbr.view).layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
            snkbr.show()
        }
    }
}