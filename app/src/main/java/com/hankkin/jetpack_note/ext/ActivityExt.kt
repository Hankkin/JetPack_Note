package com.hankkin.jetpack_note.ext

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentActivity
import com.google.android.material.snackbar.Snackbar
import com.hankkin.jetpack_note.R
import com.hankkin.jetpack_note.utils.StatusBarUtil


fun FragmentActivity.snackBarShow(view: View?, str: String) {
    view?.let { Snackbar.make(it, str, Snackbar.LENGTH_SHORT).show() }
}

fun AppCompatActivity.snackBarShow(view: View?, str: String) {
    view?.let { Snackbar.make(it, str, Snackbar.LENGTH_SHORT).show() }
}

fun AppCompatActivity.setupToolBar(toolbar: Toolbar, action: ActionBar.() -> Unit) {
    toolbar.setTitleTextColor(resources.getColor(R.color.black))
    setSupportActionBar(toolbar)
    supportActionBar?.run {
        action()
    }
}

fun AppCompatActivity.setLightMode() {
    StatusBarUtil.setLightMode(this)
}

fun FragmentActivity.clipTxt(txt: String) {
    val cm = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val mClipData = ClipData.newPlainText("Label", txt)
    cm.primaryClip = mClipData
}

