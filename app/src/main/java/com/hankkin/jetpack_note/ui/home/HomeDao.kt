package com.hankkin.jetpack_note.ui.home

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hankkin.jetpack_note.data.Component

/**
 * @author Hankkin
 * @date 2019-05-30
 */
@Dao
interface HomeDao {

    @Query("SELECT * FROM component ORDER BY id")
    fun getComponents(): LiveData<List<Component>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(plants: List<Component>)
}