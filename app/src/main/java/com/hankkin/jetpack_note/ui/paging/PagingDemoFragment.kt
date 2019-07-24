package com.hankkin.jetpack_note.ui.paging

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.hankkin.jetpack_note.R
import com.hankkin.jetpack_note.ui.adapter.PagingDemoAdapter
import kotlinx.android.synthetic.main.paging_demo_fragment.*

class PagingDemoFragment : Fragment() {

    companion object {
        fun newInstance() = PagingDemoFragment()
    }

    private lateinit var viewModel: PagingDemoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.paging_demo_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PagingDemoViewModel::class.java)

        val adapter = PagingDemoAdapter()
        rv_paging.adapter = adapter
        viewModel.allUsers.observe(this, Observer(adapter::submitList))
    }

}
