package com.hankkin.jetpack_note.ui.paging

import androidx.lifecycle.ViewModel
import com.hankkin.jetpack_note.data.respository.PagingRespository
import com.hankkin.jetpack_note.data.bean.User

class PagingWithDaoViewModel internal constructor(private val pagingRespository: PagingRespository) : ViewModel() {

    val allUsers = pagingRespository.getAllUsers()

    fun insert(text: CharSequence) {
        pagingRespository.insert(text)
    }

    fun remove(user: User) {
        pagingRespository.remove(user)
    }
}
