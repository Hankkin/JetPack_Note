package com.hankkin.jetpack_note.ext

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.google.android.material.snackbar.Snackbar

/**
 * created by ${Hankkin}
 * on 2019-06-12
 */

fun Fragment.snackBarShow(view: View, str: String) {
    Snackbar.make(view, str, Snackbar.LENGTH_SHORT).show()
}

fun Fragment.clipTxt(txt: String, activity: FragmentActivity) {
    val cm = activity.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val mClipData = ClipData.newPlainText("Label", txt)
    cm.primaryClip = mClipData
}