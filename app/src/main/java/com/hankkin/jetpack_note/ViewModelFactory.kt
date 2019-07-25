package com.hankkin.jetpack_note

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hankkin.jetpack_note.data.HomeRepository
import com.hankkin.jetpack_note.ui.home.HomeListViewModel
import com.hankkin.jetpack_note.utils.Injection

/**
 * @author Hankkin
 * @date 2019-05-30
 */
class ViewModelFactory(
    private val repository: HomeRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) =
        HomeListViewModel(repository) as T


    companion object {
        private var INSTANCE: ViewModelFactory? = null
        fun getInstance(application: Application) =
            INSTANCE ?: synchronized(ViewModelFactory::class.java) {
                INSTANCE ?: ViewModelFactory(
                    Injection.provideHomeRepository(application)
                )
            }
    }
}