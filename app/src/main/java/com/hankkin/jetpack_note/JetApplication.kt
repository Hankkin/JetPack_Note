package com.hankkin.jetpack_note

import android.app.Application
import com.tencent.bugly.Bugly

/**
 * created by ${Hankkin}
 * on 2019-06-12
 */

class JetApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Bugly.init(applicationContext, "4d0b425df7", false)
    }

}