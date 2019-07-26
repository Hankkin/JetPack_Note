package com.hankkin.jetpack_note.data.bean

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * created by ${Hankkin}
 * on 2019-07-08
 */
@Entity
data class User(@PrimaryKey(autoGenerate = true) val id: Int, val name: String)