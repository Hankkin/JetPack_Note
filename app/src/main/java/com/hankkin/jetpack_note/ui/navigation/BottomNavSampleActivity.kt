package com.hankkin.jetpack_note.ui.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.hankkin.jetpack_note.R
import com.hankkin.jetpack_note.utils.StatusBarUtil
import kotlinx.android.synthetic.main.activity_bottom_nav_sample.*
import kotlinx.android.synthetic.main.app_bar_nav_sample.toolbar

class BottomNavSampleActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_nav_sample)
        initView()
    }

    private fun initView() {
        StatusBarUtil.setLightMode(this)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(true)
        toolbar.setTitleTextColor(resources.getColor(R.color.black))
        toolbar.setNavigationOnClickListener {
            finish()
        }
        initBottomNavigation()
    }

    private fun initBottomNavigation() {
        val navController = Navigation.findNavController(this, R.id.fragment_home_sample)
        bottom_navigation_view?.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            toolbar.title = destination.label
        }
    }

}
