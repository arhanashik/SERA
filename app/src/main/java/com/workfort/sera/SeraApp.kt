package com.workfort.sera

import android.app.Application
import android.content.Context

class SeraApp: Application() {

    companion object {
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()

        context = this
    }
}