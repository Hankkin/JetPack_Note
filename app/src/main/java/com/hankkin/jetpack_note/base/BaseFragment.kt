package com.hankkin.jetpack_note.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.reactivex.disposables.CompositeDisposable

/**
 * created by ${Hankkin}
 * on 2019-06-28
 */

abstract class BaseFragment : Fragment() {

    protected var TAG: String? = null

    protected var activity: Activity? = null

    private var isShowVisible = false

    private var isInitView = false

    private var isFirstLoad = true

    var disposables = CompositeDisposable()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onAttach(context: Context) {
        context.let { super.onAttach(it) }
        TAG = javaClass.simpleName
        activity = context as Activity?
    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val convertView: View = inflater?.inflate(getLayoutId(), container, false)!!
        return convertView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initViews()
        isInitView = true
        lazyLoadData()
    }

    protected abstract fun getLayoutId(): Int

    protected abstract fun initData()

    protected abstract fun initViews()


    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        if (isVisibleToUser) {
            isShowVisible = true
            lazyLoadData()
        } else isShowVisible = false
        super.setUserVisibleHint(isVisibleToUser)
    }

    protected fun lazyLoadData() {
        if (!isFirstLoad || !isShowVisible || !isInitView) return
        initData()
        isFirstLoad = false
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.clear()
    }

}