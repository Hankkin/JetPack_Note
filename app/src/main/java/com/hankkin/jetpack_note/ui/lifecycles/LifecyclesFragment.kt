package com.hankkin.jetpack_note.ui.lifecycles

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.BounceInterpolator
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.hankkin.jetpack_note.R
import com.hankkin.jetpack_note.databinding.FragmentLifecyclesBinding
import com.hankkin.jetpack_note.ext.snackBarShow
import com.hankkin.jetpack_note.utils.FloatWindowUtils
import com.tbruyelle.rxpermissions2.RxPermissions
import com.yhao.floatwindow.FloatWindow
import com.yhao.floatwindow.PermissionListener
import com.yhao.floatwindow.Screen
import kotlinx.android.synthetic.main.fragment_lifecycles.*
import thereisnospon.codeview.CodeViewTheme

class LifecyclesFragment : Fragment() {

    private var mGpsListener: MyLocationListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentLifecyclesBinding.inflate(inflater, container, false).root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        code_view.setTheme(CodeViewTheme.ARDUINO_LIGHT).fillColor()
        code_view.showCode(resources.getString(R.string.lifecycle_codes))

        btn_add_obserber.setOnClickListener {
            if (FloatWindow.get() == null) {
                FloatWindowUtils.init(activity?.application!!)
            }
            FloatWindowUtils.show()
        }

        btn_location.setOnClickListener {
            mGpsListener = MyLocationListener()
            requestPermission()
        }
        btn_life_recommend.setOnClickListener {
            ll_life_hint.visibility = View.VISIBLE
            iv_life.visibility = View.GONE
        }
    }


    @SuppressLint("CheckResult")
    private fun requestPermission() {
        RxPermissions(activity!!)
            .requestEach(Manifest.permission.ACCESS_FINE_LOCATION)
            .subscribe { p0 ->
                when {
                    p0.granted -> {
                        BoundLocationManager.bindLocationListenerIn(this, mGpsListener, activity?.applicationContext)
                    }
                    p0.shouldShowRequestPermissionRationale -> {
                        snackBarShow(ll_life_root, "请在设置-应用-权限管理中开启权限")
                    }
                    else -> snackBarShow(ll_life_root, "权限被拒绝，无法启用定位功能")
                }
            }
    }


    private inner class MyLocationListener : LocationListener {
        override fun onLocationChanged(location: Location) {
            tv_life_location.text = location.latitude.toString() + ", " + location.longitude
        }

        override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {}

        override fun onProviderEnabled(provider: String) {
            Toast.makeText(
                context,
                "Provider enabled: $provider", Toast.LENGTH_SHORT
            ).show()
        }

        override fun onProviderDisabled(provider: String) {}
    }
}