package com.hankkin.jetpack_note

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hankkin.jetpack_note.data.respository.HomeRepository
import com.hankkin.jetpack_note.data.respository.PagingRespository
import com.hankkin.jetpack_note.data.respository.gank.GankRespository
import com.hankkin.jetpack_note.ui.home.HomeListViewModel
import com.hankkin.jetpack_note.ui.livedata.LiveDataViewModel
import com.hankkin.jetpack_note.ui.paging.PagingWithDaoViewModel
import com.hankkin.jetpack_note.ui.paging.PagingWithNetWorkViewModel
import com.hankkin.jetpack_note.utils.Injection

/**
 * @author Hankkin
 * @date 2019-05-30
 */
class ViewModelFactory(
    private val homeRepository: HomeRepository,
    private val pagingRepository: PagingRespository,
    private val gankRespository: GankRespository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        with(modelClass) {
            when {
                isAssignableFrom(HomeListViewModel::class.java) -> {
                    HomeListViewModel(homeRepository)
                }
                isAssignableFrom((LiveDataViewModel::class.java)) -> {
                    LiveDataViewModel()
                }
                isAssignableFrom(PagingWithDaoViewModel::class.java) -> {
                    PagingWithDaoViewModel(pagingRepository)
                }
                isAssignableFrom(PagingWithNetWorkViewModel::class.java) -> {
                    PagingWithNetWorkViewModel(gankRespository)
                }
                else ->
                    throw IllegalArgumentException("Unknown ViewModel: ${modelClass.name}")
            }

        } as T


    companion object {
        private var INSTANCE: ViewModelFactory? = null
        fun getInstance(application: Application) =
            INSTANCE ?: synchronized(ViewModelFactory::class.java) {
                INSTANCE ?: ViewModelFactory(
                    Injection.provideHomeRepository(application),
                    Injection.providePagingRepository(application),
                    Injection.provideGankRespository()
                )
            }
    }
}