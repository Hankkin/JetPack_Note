package com.hankkin.jetpack_note.ui.paging

import androidx.lifecycle.ViewModel
import com.hankkin.jetpack_note.data.respository.gank.GankRespository

/**
 * created by Hankkin
 * on 2019-07-30
 */
class PagingWithNetWorkViewModel(
    private val gankRespository: GankRespository
) : ViewModel() {

    private val mData = gankRespository.getGank()

    val gankList = mData.pagedList

    val netWorkState = mData.networkState

    val refreshState = mData.refreshState

    fun refresh() {
        mData.refresh.invoke()
    }

    fun retry() {
        mData.retry.invoke()
    }

}