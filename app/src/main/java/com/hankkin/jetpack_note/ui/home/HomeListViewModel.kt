package com.hankkin.jetpack_note.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.hankkin.jetpack_note.data.bean.Component
import com.hankkin.jetpack_note.data.respository.HomeRepository

/**
 * @author Hankkin
 * @date 2019-05-30
 */
class HomeListViewModel internal constructor(homeRepository: HomeRepository) : ViewModel() {

    val listData: LiveData<List<Component>> = homeRepository.getPlants()

}