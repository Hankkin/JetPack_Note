package com.hankkin.jetpack_note.ui.livedata

import androidx.arch.core.util.Function
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.hankkin.jetpack_note.data.User

/**
 * @author Hankkin
 * @date 2019-05-30
 */
class LiveDataViewModel : ViewModel() {
    val data = listOf(User(0,"Hankkin"), User(1,"Tony"),User(2,"Bob"),User(3,"Lucy"))

    val id = MutableLiveData<Int>()
    //map转换返回User实体
    val bean: LiveData<User> = Transformations.map(id, Function {
        return@Function findUserById(id.value!!)
    })
    //根据id查找User
    private fun findUserById(id: Int): User? {
        return data.find { it.id == id }
    }
}