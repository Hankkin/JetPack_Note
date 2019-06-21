package com.hankkin.jetpack_note.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.hankkin.jetpack_note.R
import com.hankkin.jetpack_note.ui.livedata.LiveDataFragment
import com.hankkin.jetpack_note.ui.viewmodel.ViewModelFragment
import com.hankkin.jetpack_note.widget.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_more_sample.*

class MoreSampleActivity : AppCompatActivity() {

    private val mTitles = arrayOf("ViewModel", "LiveData", "Paging", "Room", "WorkManager", "Camera2")
    private val mFgs by lazy {
        arrayOf(
            ViewModelFragment(),
            LiveDataFragment(),
            LiveDataFragment(),
            LiveDataFragment(),
            LiveDataFragment(),
            LiveDataFragment()
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more_sample)

        vp.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount() = mFgs.size
            override fun createFragment(position: Int) = mFgs[position]
        }
        vp.offscreenPageLimit = mTitles.size
        TabLayoutMediator(tab, vp,
            TabLayoutMediator.OnConfigureTabCallback { tab, position -> tab.text = mTitles[position] }).attach()
    }
}
