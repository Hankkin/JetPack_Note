package com.hankkin.jetpack_note.utils

import android.content.Context
import com.hankkin.jetpack_note.data.db.HomeDB
import com.hankkin.jetpack_note.data.respository.HomeRepository
import com.hankkin.jetpack_note.data.respository.PagingRespository
import com.hankkin.jetpack_note.data.db.UserDB

/**
 * @author Hankkin
 * @date 2019-05-30
 */
object Injection {


    fun provideHomeRepository(context: Context): HomeRepository {
        return HomeRepository.getInstance(
            HomeDB.getInstance(context.applicationContext).homeDao()
        )
    }

    fun providePagingRepository(context: Context): PagingRespository {
        return PagingRespository.getInstance(
            UserDB.get(context.applicationContext).userDao()
        )
    }
}