package com.hankkin.jetpack_note.ui.paging

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.hankkin.jetpack_note.R
import kotlinx.android.synthetic.main.paging_demo_fragment.*

class PagingDemoFragment : Fragment() {

    companion object {
        fun newInstance() = PagingDemoFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.paging_demo_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btn_paging_dao.setOnClickListener { findNavController().navigate(R.id.pagingWithDaoActivity) }
        btn_paging_net.setOnClickListener { findNavController().navigate(R.id.pagingWithNetWorkActivity) }
    }

}
