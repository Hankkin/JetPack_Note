package com.hankkin.jetpack_note.ui.home

/**
 * @author Hankkin
 * @date 2019-05-30
 */
class HomeRepository private constructor(private val homeDao: HomeDao) {


    companion object {

        // For Singleton instantiation
        @Volatile private var instance: HomeRepository? = null

        fun getInstance(plantDao: HomeDao) =
            instance ?: synchronized(this) {
                instance ?: HomeRepository(plantDao).also { instance = it }
            }
    }

}