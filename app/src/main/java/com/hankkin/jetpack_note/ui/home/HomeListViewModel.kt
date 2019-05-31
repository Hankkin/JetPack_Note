package com.hankkin.jetpack_note.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.hankkin.jetpack_note.data.Component

/**
 * @author Hankkin
 * @date 2019-05-30
 */
class HomeListViewModel internal constructor(homeRepository: HomeRepository) : ViewModel() {

    val listData: LiveData<List<Component>> = homeRepository.getPlants()

}