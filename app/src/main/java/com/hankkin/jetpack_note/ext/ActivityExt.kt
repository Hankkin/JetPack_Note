package com.hankkin.jetpack_note.ext

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.google.android.material.snackbar.Snackbar
import com.hankkin.jetpack_note.R


fun FragmentActivity.snackBarShow(view: View?, str: String) {
    view?.let { Snackbar.make(it, str, Snackbar.LENGTH_SHORT).show() }
}

fun AppCompatActivity.snackBarShow(view: View?, str: String) {
    view?.let { Snackbar.make(it, str, Snackbar.LENGTH_SHORT).show() }
}

fun FragmentActivity.clipTxt(txt: String) {
    val cm = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val mClipData = ClipData.newPlainText("Label", txt)
    cm.primaryClip = mClipData
}

