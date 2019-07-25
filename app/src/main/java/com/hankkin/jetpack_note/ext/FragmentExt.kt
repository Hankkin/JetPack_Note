package com.hankkin.jetpack_note.ext

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar
import com.hankkin.jetpack_note.ViewModelFactory

/**
 * created by ${Hankkin}
 * on 2019-06-12
 */

fun Fragment.snackBarShow(view: View, str: String) {
    Snackbar.make(view, str, Snackbar.LENGTH_SHORT).show()
}

fun Fragment.clipTxt(txt: String) {
    val cm = activity?.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val mClipData = ClipData.newPlainText("Label", txt)
    cm.primaryClip = mClipData
}

fun <T : ViewModel> Fragment.obtainViewModel(viewModelClass: Class<T>) =
    ViewModelProviders.of(this, activity?.application?.let { ViewModelFactory.getInstance(it) }).get(viewModelClass)