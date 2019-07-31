package com.hankkin.jetpack_note.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.hankkin.jetpack_note.R
import com.hankkin.jetpack_note.ui.other.CommonWebActivity
import com.hankkin.jetpack_note.utils.AppUtils
import com.hankkin.jetpack_note.utils.CommonUtils
import com.hankkin.jetpack_note.utils.Constants
import kotlinx.android.synthetic.main.fragment_about.*

/**
 * 关于我们
 */
class AboutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        context?.run {
            tv_about_version_code.text = "V ${AppUtils.getVersionName(this)}"
            iv_about_github.setOnClickListener { CommonWebActivity.loadUrl(this, Constants.AboutUrl.GITHUB, Constants.AboutUrl.GITHUB_TITLE) }
            iv_about_juejin.setOnClickListener { CommonWebActivity.loadUrl(this, Constants.AboutUrl.JUEJIN, Constants.AboutUrl.JUEJIN_TITLE) }
            iv_about_jianshu.setOnClickListener { CommonWebActivity.loadUrl(this, Constants.AboutUrl.JIANSHU, Constants.AboutUrl.JIANSHU_TITLE) }
            iv_about_csdn.setOnClickListener { CommonWebActivity.loadUrl(this, Constants.AboutUrl.CSDN, Constants.AboutUrl.CSDN_TITLE) }
            tv_about_rate.setOnClickListener { CommonUtils.gradeApp(this) }
            tv_about_blog.setOnClickListener { CommonWebActivity.loadUrl(this, Constants.AboutUrl.BLOG, Constants.AboutUrl.BLOG_TITLE) }
        }
    }

}
