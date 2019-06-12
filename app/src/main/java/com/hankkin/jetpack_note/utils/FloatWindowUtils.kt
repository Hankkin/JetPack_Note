package com.hankkin.jetpack_note.utils

import android.app.Application
import android.util.Log
import android.view.LayoutInflater
import android.view.animation.BounceInterpolator
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.google.android.material.button.MaterialButton
import com.hankkin.jetpack_note.MainActivity
import com.hankkin.jetpack_note.R
import com.yhao.floatwindow.*

/**
 * created by ${Hankkin}
 * on 2019-06-12
 */

object FloatWindowUtils {

    private const val TAG = "FloatWindowUtils"

    fun init(application: Application) {
        FloatWindow
            .with(application.applicationContext)
            .setView(R.layout.layout_float_view)
            .setWidth(Screen.width, 0.7f) //设置悬浮控件宽高
            .setHeight(Screen.height, 0.3f)
            .setX(Screen.width, 0.3f)
            .setY(Screen.height, 0.45f)
            .setMoveType(MoveType.slide, 100, 0)
            .setMoveStyle(500, BounceInterpolator())
            .setDesktopShow(true)
            .setFilter(true, MainActivity::class.java)
            .setPermissionListener(mPermissionListener)
            .setViewStateListener(mViewStateListener)
            .build()
        val view = FloatWindow.get().view
        val ll = view.findViewById<LinearLayout>(R.id.ll_flow_content)
        view.findViewById<AppCompatButton>(R.id.btn_float_close).setOnClickListener { destroy() }
        view.findViewById<AppCompatButton>(R.id.btn_float_clear).setOnClickListener {
            ll.removeAllViews()
        }
    }

    fun show() {
        if (FloatWindow.get() != null && !FloatWindow.get().isShowing) {
            FloatWindow.get().show()
        }
    }

    fun hide() {
        if (FloatWindow.get() != null && FloatWindow.get().isShowing) {
            FloatWindow.get().hide()
        }
    }

    fun destroy() {
        if (FloatWindow.get() != null) {
            FloatWindow.destroy()
        }
    }

    fun addViewContent(msg: String) {
        if (FloatWindow.get() == null) return
        val view = FloatWindow.get().view
        val ll = view.findViewById<LinearLayout>(R.id.ll_flow_content)
        val tv = TextView(view.context)
        tv.text = msg
        ll.addView(tv)
    }

    private val mPermissionListener = object : PermissionListener {
        override fun onSuccess() {
            Log.d(TAG, "onSuccess")
        }

        override fun onFail() {
            Log.d(TAG, "onFail")
        }
    }

    private val mViewStateListener = object : ViewStateListener {
        override fun onPositionUpdate(x: Int, y: Int) {
            Log.d(TAG, "onPositionUpdate: x=$x y=$y")
        }

        override fun onShow() {
            Log.d(TAG, "onShow")
        }

        override fun onHide() {
            Log.d(TAG, "onHide")
        }

        override fun onDismiss() {
            Log.d(TAG, "onDismiss")
        }

        override fun onMoveAnimStart() {
            Log.d(TAG, "onMoveAnimStart")
        }

        override fun onMoveAnimEnd() {
            Log.d(TAG, "onMoveAnimEnd")
        }

        override fun onBackToDesktop() {
            Log.d(TAG, "onBackToDesktop")
        }
    }
}