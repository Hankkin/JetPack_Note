package com.hankkin.jetpack_note.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.hankkin.jetpack_note.R
import com.hankkin.jetpack_note.adapter.HomeListAdapter
import com.hankkin.jetpack_note.databinding.FragmentHomeBinding
import com.hankkin.jetpack_note.utils.InjectorUtils
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    private var isLine: Boolean = false

    private val viewModel: HomeListViewModel by viewModels {
        InjectorUtils.provideHomeListViewModelFactory(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        context ?: return binding.root

        val adapter = HomeListAdapter()
        binding.rvHome.adapter = adapter
        subscribeUi(adapter, binding)
        return binding.root
    }


    private fun subscribeUi(adapter: HomeListAdapter, binding: FragmentHomeBinding) {
        viewModel.listData.observe(viewLifecycleOwner, Observer { data ->
            if (data != null) adapter.submitList(data)
        })
        binding.fab.setOnClickListener {
            binding.rvHome.layoutManager = if (isLine) GridLayoutManager(context,2) else LinearLayoutManager(context)
            binding.fab.setImageResource(if (isLine) R.mipmap.icon_lin else R.mipmap.icon_grid)
            isLine = !isLine
        }
    }

}