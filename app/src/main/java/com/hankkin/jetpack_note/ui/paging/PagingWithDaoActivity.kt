package com.hankkin.jetpack_note.ui.paging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.hankkin.jetpack_note.R
import com.hankkin.jetpack_note.ext.setLightMode
import com.hankkin.jetpack_note.ext.setupToolBar
import com.hankkin.jetpack_note.ui.adapter.PagingDemoAdapter
import kotlinx.android.synthetic.main.activity_paging_with_dao.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class PagingWithDaoActivity : AppCompatActivity() {

    private lateinit var viewModel: PagingWithDaoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paging_with_dao)
        setLightMode()
        setupToolBar(toolbar) {
            title = resources.getString(R.string.paging_with_dao)
            setDisplayHomeAsUpEnabled(true)
        }
        viewModel = ViewModelProviders.of(this).get(PagingWithDaoViewModel::class.java)
        val adapter = PagingDemoAdapter()
        rv_paging.adapter = adapter
        viewModel.allUsers.observe(this, Observer(adapter::submitList))
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
