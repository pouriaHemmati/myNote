package com.covid19.base

import android.app.Application
import android.content.Context

class BaseActivity: Application()  {

    init {
        instanceContext = this
    }

    companion object {
        private var instanceContext: BaseActivity? = null
        fun applicationContext() : Context {
            return instanceContext!!.applicationContext
        }

    }









}