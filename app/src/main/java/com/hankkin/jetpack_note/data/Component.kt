package com.hankkin.jetpack_note.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

/**
 * @author Hankkin
 * @date 2019-05-30
 */
@Entity(tableName = "component")
data class Component (
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    val title: String,
    val description: String,
    val link: String
){
    override fun toString() = title
}