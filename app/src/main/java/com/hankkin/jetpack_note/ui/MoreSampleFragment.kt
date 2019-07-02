package com.hankkin.jetpack_note.ui


import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.adapter.FragmentStateAdapter

import com.hankkin.jetpack_note.R
import com.hankkin.jetpack_note.ui.livedata.LiveDataFragment
import com.hankkin.jetpack_note.ui.viewmodel.ViewModelFragment
import com.hankkin.jetpack_note.widget.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_more_sample.*
import kotlinx.android.synthetic.main.layout_loading.*


/**
 *More Demo
 */
class MoreSampleFragment : Fragment() {

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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_more_sample, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler().postDelayed({
            setUI()
            loading.visibility = View.GONE
        }, 500)
    }

    private fun setUI() {
        vp.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount() = mFgs.size
            override fun createFragment(position: Int) = mFgs[position]
        }
        vp.offscreenPageLimit = mTitles.size
        TabLayoutMediator(tab, vp,
            TabLayoutMediator.OnConfigureTabCallback { tab, position -> tab.text = mTitles[position] }).attach()
    }


}
