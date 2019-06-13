package com.hankkin.jetpack_note.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.hankkin.jetpack_note.R
import com.hankkin.jetpack_note.databinding.ActivityMainBinding
import com.hankkin.jetpack_note.utils.StatusBarUtil

class MainActivity : AppCompatActivity() {

    private lateinit var mDataBinding: ActivityMainBinding
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        StatusBarUtil.setLightMode(this)
        mDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        drawerLayout = mDataBinding.drawerLayout
        mDataBinding.toolbar.setTitleTextColor(resources.getColor(R.color.black))

        navController = Navigation.findNavController(this, R.id.fragment_home)
        appBarConfiguration = AppBarConfiguration(setOf(
            R.id.homeFragment,
            R.id.codeFragment
        ), drawerLayout)
        // Set up ActionBar
        setSupportActionBar(mDataBinding.toolbar)
        setupActionBarWithNavController(navController, appBarConfiguration)
        // Set up navigation menu
        mDataBinding.navView.setupWithNavController(navController)
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
