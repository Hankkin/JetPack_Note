package com.hankkin.jetpack_note.data

/**
 * @author Hankkin
 * @date 2019-05-30
 */
class HomeRepository private constructor(private val homeDao: HomeDao) {


    fun getPlants() = homeDao.getComponents()

    companion object {

        // For Singleton instantiation
        @Volatile private var instance: HomeRepository? = null

        fun getInstance(plantDao: HomeDao) =
            instance ?: synchronized(this) {
                instance
                    ?: HomeRepository(plantDao).also { instance = it }
            }
    }

}