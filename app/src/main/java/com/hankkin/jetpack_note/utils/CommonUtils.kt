package com.hankkin.jetpack_note.utils

import android.app.Activity
import android.content.Intent
import android.net.Uri


object CommonUtils {

    fun share(context: Activity, text: String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, text)
        context.startActivity(intent)
    }

    fun openBrowser(context: Activity, url: String) {
        val intent = Intent()
        intent.action = "android.intent.action.VIEW"
        val mUri = Uri.parse(url)
        intent.data = mUri
        context.startActivity(intent)
    }


}