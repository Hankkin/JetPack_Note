package com.hankkin.jetpack_note.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * created by ${Hankkin}
 * on 2019-06-18
 */
class SeekBarViewModel : ViewModel() {
    var seekbarValue = MutableLiveData<Int>()
}