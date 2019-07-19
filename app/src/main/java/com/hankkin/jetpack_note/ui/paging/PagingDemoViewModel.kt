package com.hankkin.jetpack_note.ui.paging

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.paging.toLiveData
import com.hankkin.jetpack_note.data.User
import com.hankkin.jetpack_note.data.UserDB
import com.hankkin.jetpack_note.data.ioThread
import androidx.paging.Config

class PagingDemoViewModel(app: Application) : AndroidViewModel(app) {

    val dao = UserDB.get(app).userDao()

    /**
     * We use -ktx Kotlin extension functions here, otherwise you would use LivePagedListBuilder(),
     * and PagedList.Config.Builder()
     */
    val allUsers = dao.queryUsersByName().toLiveData(
        Config(
            /**
             * A good page size is a value that fills at least a screen worth of content on a large
             * device so the User is unlikely to see a null item.
             * You can play with this constant to observe the paging behavior.
             * <p>
             * It's possible to vary this with list device size, but often unnecessary, unless a
             * user scrolling on a large device is expected to scroll through items more quickly
             * than a small device, such as when the large device uses a grid layout of items.
             */
            pageSize = 20,

            /**
             * If placeholders are enabled, PagedList will report the full size but some items might
             * be null in onBind method (PagedListAdapter triggers a rebind when data is loaded).
             * <p>
             * If placeholders are disabled, onBind will never receive null but as more pages are
             * loaded, the scrollbars will jitter as new pages are loaded. You should probably
             * disable scrollbars if you disable placeholders.
             */
            enablePlaceholders = true,

            /**
             * Maximum number of items a PagedList should hold in memory at once.
             * <p>
             * This number triggers the PagedList to start dropping distant pages as more are loaded.
             */
            maxSize = 200
        )
    )

    fun insert(text: CharSequence) = ioThread {
        dao.insert(User(id = 0, name = text.toString()))
    }

    fun remove(cheese: User) = ioThread {
        dao.delete(cheese)
    }

}
