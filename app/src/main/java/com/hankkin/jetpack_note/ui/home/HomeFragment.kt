package com.hankkin.jetpack_note.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.hankkin.jetpack_note.adapter.HomeListAdapter
import com.hankkin.jetpack_note.databinding.FragmentHomeBinding
import com.hankkin.jetpack_note.utils.InjectorUtils

class HomeFragment : Fragment() {

    private val viewModel: HomeListViewModel by viewModels {
        InjectorUtils.provideHomeListViewModelFactory(requireContext())
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        context ?: return binding.root

        val adapter = HomeListAdapter()
        binding.rvHome.adapter = adapter
        subscribeUi(adapter)
        return binding.root
    }


    private fun subscribeUi(adapter: HomeListAdapter) {
        viewModel.listData.observe(viewLifecycleOwner, Observer { data ->
            if (data != null) adapter.submitList(data)
        })
    }

}