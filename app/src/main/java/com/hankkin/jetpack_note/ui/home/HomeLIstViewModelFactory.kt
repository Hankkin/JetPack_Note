package com.hankkin.jetpack_note.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hankkin.jetpack_note.data.HomeRepository

/**
 * @author Hankkin
 * @date 2019-05-30
 */
class HomeLIstViewModelFactory (
    private val repository: HomeRepository
) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) = HomeListViewModel(repository) as T
}