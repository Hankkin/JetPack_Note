package com.hankkin.jetpack_note.utils

import android.content.Context
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.hankkin.jetpack_note.R
import com.hankkin.jetpack_note.ui.other.CommonWebActivity

/**
 * created by Hankkin
 * on 2019-07-31
 */
object ViewHelper {
    /**
     * about dialog
     */
    fun showAboutDialog(context: Context): Boolean {
        LayoutInflater.from(context).inflate(R.layout.layout_about_dialog, null)
            .apply {
                findViewById<TextView>(R.id.tv_about_version_code).setText(AppUtils.getVersionName(context))
                findViewById<ImageView>(R.id.iv_about_github).setOnClickListener { CommonWebActivity.loadUrl(context, Constants.AboutUrl.GITHUB, Constants.AboutUrl.GITHUB_TITLE) }
                findViewById<ImageView>(R.id.iv_about_juejin).setOnClickListener { CommonWebActivity.loadUrl(context, Constants.AboutUrl.JUEJIN, Constants.AboutUrl.JUEJIN_TITLE) }
                findViewById<ImageView>(R.id.iv_about_jianshu).setOnClickListener { CommonWebActivity.loadUrl(context, Constants.AboutUrl.JIANSHU, Constants.AboutUrl.JIANSHU_TITLE) }
                findViewById<ImageView>(R.id.iv_about_csdn).setOnClickListener { CommonWebActivity.loadUrl(context, Constants.AboutUrl.CSDN, Constants.AboutUrl.CSDN_TITLE) }
                val bottomSheet = BottomSheetDialog(context, R.style.BottomSheetDialog)
                findViewById<TextView>(R.id.tv_about_close).setOnClickListener { bottomSheet.dismiss() }
                findViewById<TextView>(R.id.tv_about_rate).setOnClickListener { CommonUtils.gradeApp(context) }
                bottomSheet.setContentView(this)
                bottomSheet.show()
            }
        return false
    }
}