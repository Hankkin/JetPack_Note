package com.hankkin.jetpack_note.utils

import android.content.Context
import com.hankkin.jetpack_note.data.HomeDatabase
import com.hankkin.jetpack_note.ViewModelFactory
import com.hankkin.jetpack_note.data.HomeRepository

/**
 * @author Hankkin
 * @date 2019-05-30
 */
object Injection {


    fun provideHomeRepository(context: Context): HomeRepository {
        return HomeRepository.getInstance(
            HomeDatabase.getInstance(context.applicationContext).homeDao()
        )
    }
}