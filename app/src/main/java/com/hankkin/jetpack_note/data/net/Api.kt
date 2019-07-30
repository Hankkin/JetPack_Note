package com.hankkin.jetpack_note.data.net

import com.hankkin.jetpack_note.data.bean.GankResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * created by Hankkin
 * on 2019-07-30
 */
interface Api {

    @GET("data/Android/{count}/{page}")
    fun getGank(
        @Path("count") count: Int,
        @Path("page") page: Int
    ): Call<GankResponse>

}