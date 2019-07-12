package com.hankkin.jetpack_note.ui.viewmodel


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.hankkin.jetpack_note.R
import kotlinx.android.synthetic.main.fragment_data_share.*


/**
* DataShare
 */
class DataShareFragment : Fragment() {

    private lateinit var mViewModel: DemoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mViewModel = ViewModelProviders.of(activity!!).get(DemoViewModel::class.java)
        return inflater.inflate(R.layout.fragment_data_share, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        subscribeSeekBar()
    }

    private fun subscribeSeekBar() {
        // 监听SeekBar改变ViewModel的中的值
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    mViewModel.seekbarValue.value = progress
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}

            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })
        // 当ViewModel中的值发生变化时，更新SeekBar
        activity?.let {
            mViewModel.seekbarValue.observe(it, Observer<Int> { value ->
                if (value != null) {
                    seekBar.progress = value
                }
            })
        }
    }
}
