package com.hankkin.jetpack_note.ui.livedata

import androidx.arch.core.util.Function
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

/**
 * @author Hankkin
 * @date 2019-05-30
 */
class LiveDataViewModel : ViewModel() {

    val map = mapOf(Pair("1", "Navigation"), Pair("2", "Lifecycles"), Pair("3", "LiveData"), Pair("4", "ViewModel"))
    val id = MutableLiveData<String>()
    val bean: LiveData<String> = Transformations.map(id, Function {
        return@Function map[id.value]
    })
}