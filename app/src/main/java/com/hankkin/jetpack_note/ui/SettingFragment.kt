package com.hankkin.jetpack_note.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hankkin.jetpack_note.R
import com.hankkin.jetpack_note.ui.other.CommonWebActivity
import com.hankkin.jetpack_note.utils.Constants
import com.tencent.bugly.beta.Beta
import kotlinx.android.synthetic.main.fragment_setting.*


/**
 *设置
 */
class SettingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_setting, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        ll_setting_update.setOnClickListener {
            Beta.checkUpgrade(true, false)
        }
        ll_setting_github.setOnClickListener {
            activity?.let { it1 -> CommonWebActivity.loadUrl(it1, Constants.AboutUrl.JETPACK, Constants.AboutUrl.JETPACK_TITLE) }
        }
    }
}
