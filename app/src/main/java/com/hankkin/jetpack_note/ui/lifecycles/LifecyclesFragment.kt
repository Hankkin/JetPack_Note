package com.hankkin.jetpack_note.ui.lifecycles

import android.Manifest
import android.annotation.SuppressLint
import android.location.Location
import android.location.LocationListener
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.hankkin.jetpack_note.R
import com.hankkin.jetpack_note.ext.snackBarShow
import com.hankkin.jetpack_note.utils.FloatWindowUtils
import com.tbruyelle.rxpermissions2.RxPermissions
import com.yhao.floatwindow.FloatWindow
import kotlinx.android.synthetic.main.fragment_lifecycles.*

class LifecyclesFragment : Fragment() {

    private var mGpsListener: MyLocationListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_lifecycles, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setUI()
    }

    private fun setUI() {

        btn_add_obserber.setOnClickListener {
            if (FloatWindow.get() == null) {
                FloatWindowUtils.init(activity?.application!!)
            }
            FloatWindowUtils.show()
        }

        btn_location.setOnClickListener {
            if (mGpsListener != null) {
                snackBarShow(ll_life_root, getString(R.string.has_location_hint))
                return@setOnClickListener
            }
            mGpsListener = MyLocationListener()
            requestPermission()
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