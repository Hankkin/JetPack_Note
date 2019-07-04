package com.hankkin.jetpack_note.ui.livedata


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.hankkin.jetpack_note.R
import com.hankkin.jetpack_note.utils.FloatWindowUtils
import com.yhao.floatwindow.FloatWindow
import kotlinx.android.synthetic.main.fragment_live_data.*


/**
 *LiveData
 */
class LiveDataFragment : Fragment() {

    private lateinit var liveData: MutableLiveData<String>
    private var mId = 1

    private val viewModel: LiveDataViewModel by lazy { ViewModelProviders.of(this).get(LiveDataViewModel::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_live_data, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        liveData = MutableLiveData()
        btn_observer_data.setOnClickListener {
            if (FloatWindow.get() == null) {
                FloatWindowUtils.init(activity?.application!!)
            }
            FloatWindowUtils.show()

            //创建一个观察者去更新UI
            val statusObserver = Observer<String> { lifeStatus ->
                FloatWindowUtils.addViewContent("LiveData-onChanged: $lifeStatus")
            }
            liveData.observeForever(statusObserver)
        }
        btn_observer_map.setOnClickListener {
            viewModel.id.postValue("${mId++}")
        }
        viewModel.bean.observe(this, Observer { tv_livedata_map.text = it ?: "暂无数据" })
    }

    override fun onStart() {
        super.onStart()
        liveData.value = "onStart()"
    }

    override fun onPause() {
        super.onPause()
        liveData.value = "onPause()"
    }

    override fun onStop() {
        super.onStop()
        liveData.value = "onStop()"
    }

    override fun onDestroy() {
        super.onDestroy()
        liveData.value = "onDestroy()"
    }

}
