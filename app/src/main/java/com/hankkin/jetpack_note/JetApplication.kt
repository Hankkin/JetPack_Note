package com.hankkin.jetpack_note

import android.annotation.SuppressLint
import android.app.Application
import com.tencent.bugly.crashreport.CrashReport

/**
 * created by ${Hankkin}
 * on 2019-06-12
 */

class JetApplication : Application() {

    @SuppressLint("MissingSuperCall")
    override fun onCreate() {
        CrashReport.initCrashReport(applicationContext, "4d0b425df7", false)
    }

}