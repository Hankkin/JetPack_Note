/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hankkin.jetpack_note.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList

/**
 * Data class that is necessary for a UI to show a listing and interact w/ the rest of the system
 * 封装需要监听的对象和执行的操作，用于上拉下拉操作
 * pagedList ： 数据列表
 * networkState ： 网络状态
 * refreshState ： 刷新状态
 * refresh ： 刷新操作
 * retry ： 重试操作
 */
data class Listing<T>(
        // the LiveData of paged lists for the UI to observe
    val pagedList: LiveData<PagedList<T>>,
        // represents the network request status to show to the user
    val networkState: LiveData<NetworkState>,
        // represents the refresh status to show to the user. Separate from networkState, this
        // value is importantly only when refresh is requested.
    val refreshState: LiveData<NetworkState>,
        // refreshes the whole data and fetches it from scratch.
    val refresh: () -> Unit,
        // retries any failed requests.
    val retry: () -> Unit)