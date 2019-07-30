package com.hankkin.jetpack_note.data.bean

import java.io.Serializable
import java.util.*


data class GankResponse(val error: Boolean, val results: List<Gank>)

data class Gank(
    val _id: String = "",
    val createdAt: Date = Date(),
    val desc: String = "",
    val images: MutableList<String> = mutableListOf(),
    val publishedAt: Date = Date(),
    val source: String = "",
    val type: String = "",
    val url: String = "",
    val used: Boolean = false,
    val who: String = ""
) : Serializable

