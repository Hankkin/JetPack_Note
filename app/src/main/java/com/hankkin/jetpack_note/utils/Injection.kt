package com.hankkin.jetpack_note.utils

import android.content.Context
import com.hankkin.jetpack_note.data.db.HomeDB
import com.hankkin.jetpack_note.data.respository.HomeRepository
import com.hankkin.jetpack_note.data.respository.PagingRespository
import com.hankkin.jetpack_note.data.db.UserDB
import com.hankkin.jetpack_note.data.net.Api
import com.hankkin.jetpack_note.data.net.HttpClient
import com.hankkin.jetpack_note.data.respository.gank.GankRespository

/**
 * @author Hankkin
 * @date 2019-05-30
 */
object Injection {


    fun provideHomeRepository(context: Context) =
        HomeRepository.getInstance(
            HomeDB.getInstance(context.applicationContext).homeDao()
        )

    fun providePagingRepository(context: Context) =
        PagingRespository.getInstance(
            UserDB.get(context.applicationContext).userDao()
        )

    fun provideGankRespository() = GankRespository.getInstance()

    fun provideApi(): Api = HttpClient.instance
}