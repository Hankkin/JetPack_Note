package com.hankkin.jetpack_note.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.hankkin.jetpack_note.data.NetworkState
import com.hankkin.jetpack_note.data.bean.Gank
import com.hankkin.jetpack_note.databinding.AdapterPagingWithNetworkItemBinding
import com.hankkin.jetpack_note.ui.other.CommonWebActivity

/**
 * created by Hankkin
 * on 2019-07-30
 */
class PagingWithNetWorkAdapter : PagedListAdapter<Gank, PagingWithNetWorkAdapter.ViewHolder>(diffCallback) {

    private var networkState: NetworkState? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(AdapterPagingWithNetworkItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.apply {
            bind(createOnClickListener(item), item)
            itemView.tag = item
        }
    }


    class ViewHolder(private val binding: AdapterPagingWithNetworkItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(listener: View.OnClickListener, item: Gank?) {
            binding.apply {
                clickListener = listener
                gank = item
                executePendingBindings()
            }
        }
    }

    private fun createOnClickListener(item: Gank?): View.OnClickListener {
        return View.OnClickListener {
            item?.run {
                CommonWebActivity.loadUrl(it.context, url, desc)
            }
        }
    }

    companion object {
        /**
         * This diff callback informs the PagedListAdapter how to compute list differences when new
         * PagedLists arrive.
         * <p>
         * When you add a Cheese with the 'Add' button, the PagedListAdapter uses diffCallback to
         * detect there's only a single item difference from before, so it only needs to animate and
         * rebind a single view.
         *
         * @see android.support.v7.util.DiffUtil
         */
        private val diffCallback = object : DiffUtil.ItemCallback<Gank>() {
            override fun areItemsTheSame(oldItem: Gank, newItem: Gank): Boolean =
                oldItem._id == newItem._id

            /**
             * Note that in kotlin, == checking on data classes compares all contents, but in Java,
             * typically you'll implement Object#equals, and use it to compare object contents.
             */
            override fun areContentsTheSame(oldItem: Gank, newItem: Gank): Boolean =
                oldItem == newItem
        }
    }

    private fun hasExtraRow() = networkState != null && networkState != NetworkState.HIDDEN

    fun setNetworkState(newNetworkState: NetworkState) {
        val previousState = this.networkState
        val hadExtraRow = hasExtraRow()
        this.networkState = newNetworkState
        val hasExtraRow = hasExtraRow()
        if (hadExtraRow != hasExtraRow) {
            if (hadExtraRow) {
                notifyItemRemoved(super.getItemCount())
            } else {
                notifyItemInserted(super.getItemCount())
            }
        } else if (hasExtraRow && previousState != newNetworkState) {
            notifyItemChanged(itemCount - 1)
        }
    }
}