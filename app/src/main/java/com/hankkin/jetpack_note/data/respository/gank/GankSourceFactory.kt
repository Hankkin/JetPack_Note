package com.hankkin.jetpack_note.data.respository.gank

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.hankkin.jetpack_note.data.bean.Gank
import com.hankkin.jetpack_note.data.net.Api
import com.hankkin.jetpack_note.utils.Injection

/**
 * created by Hankkin
 * on 2019-07-30
 */
class GankSourceFactory(private val api: Api = Injection.provideApi()) : DataSource.Factory<Int, Gank>(){

    val sourceLiveData = MutableLiveData<GankDataSource>()

    override fun create(): DataSource<Int, Gank> {
        val source = GankDataSource(api)
        sourceLiveData.postValue(source)
        return  source
    }
}