package com.hankkin.jetpack_note.utils

import android.content.Context
import com.hankkin.jetpack_note.data.AppDatabase
import com.hankkin.jetpack_note.ui.home.HomeLIstViewModelFactory
import com.hankkin.jetpack_note.ui.home.HomeRepository

/**
 * @author Hankkin
 * @date 2019-05-30
 */
object InjectorUtils {


    private fun getHomeRepository(context: Context): HomeRepository {
        return HomeRepository.getInstance(
            AppDatabase.getInstance(context.applicationContext).homeDao())
    }

    fun provideHomeListViewModelFactory(context: Context): HomeLIstViewModelFactory {
        val repository = getHomeRepository(context)
        return HomeLIstViewModelFactory(repository)
    }
}