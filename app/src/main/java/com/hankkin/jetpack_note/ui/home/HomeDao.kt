package com.hankkin.jetpack_note.ui.home

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.hankkin.jetpack_note.data.Component

/**
 * @author Hankkin
 * @date 2019-05-30
 */
@Dao
interface HomeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(plants: List<Component>)
}