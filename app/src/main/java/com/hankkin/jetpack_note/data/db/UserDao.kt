package com.hankkin.jetpack_note.data.db

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.hankkin.jetpack_note.data.bean.User

/**
 * created by Hankkin
 * on 2019-07-19
 */
@Dao
interface UserDao {


    @Query("SELECT * FROM User ORDER BY name COLLATE NOCASE ASC")
    fun queryUsersByName(): DataSource.Factory<Int, User>

    @Insert
    fun insert(users: List<User>)

    @Insert
    fun insert(user: User)

    @Delete
    fun delete(user: User)

}