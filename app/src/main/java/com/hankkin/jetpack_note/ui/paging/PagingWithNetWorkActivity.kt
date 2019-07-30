package com.hankkin.jetpack_note.ui.paging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.hankkin.jetpack_note.R
import com.hankkin.jetpack_note.data.NetworkState
import com.hankkin.jetpack_note.databinding.ActivityPagingWithNetWorkBinding
import com.hankkin.jetpack_note.ext.obtainViewModel
import com.hankkin.jetpack_note.ext.setLightMode
import com.hankkin.jetpack_note.ext.setupToolBar
import com.hankkin.jetpack_note.ui.adapter.PagingWithNetWorkAdapter
import kotlinx.android.synthetic.main.layout_toolbar.*

class PagingWithNetWorkActivity : AppCompatActivity() {

    private lateinit var mViewModel: PagingWithNetWorkViewModel
    private lateinit var mDataBinding: ActivityPagingWithNetWorkBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mDataBinding = DataBindingUtil.setContentView(this,R.layout.activity_paging_with_net_work)
        setLightMode()
        setupToolBar(toolbar) {
            title = resources.getString(R.string.paging_with_network)
            setDisplayHomeAsUpEnabled(true)
        }
        mViewModel = obtainViewModel(PagingWithNetWorkViewModel::class.java)
        mDataBinding.vm = mViewModel
        mDataBinding.lifecycleOwner = this

        val adapter = PagingWithNetWorkAdapter()
        mDataBinding.rvPagingWithNetwork.adapter = adapter
        mDataBinding.vm?.gankList?.observe(this, Observer { adapter.submitList(it) })
        mDataBinding.vm?.refreshState?.observe(this, Observer {
            mDataBinding.rvPagingWithNetwork.post {
                mDataBinding.swipeRefresh.isRefreshing = it == NetworkState.LOADING
            }
        })

        mDataBinding.vm?.netWorkState?.observe(this, Observer {
            adapter.setNetworkState(it)
        })
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
