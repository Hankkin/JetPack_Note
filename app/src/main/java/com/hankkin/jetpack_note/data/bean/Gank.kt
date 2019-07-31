package com.hankkin.jetpack_note.data.bean

import java.io.Serializable


data class GankResponse(val error: Boolean, val results: List<Gank>)

data class Gank(
    val _id: String = "",
    val createdAt: String = "",
    val desc: String = "",
    val images: MutableList<String> = mutableListOf(),
    val source: String = "",
    val type: String = "",
    val publishedAt: String = "",
    val url: String = "",
    val used: Boolean = false,
    val who: String = ""
) : Serializable {
    val published: String
        get() = publishedAt.substring(0, 10)
}

