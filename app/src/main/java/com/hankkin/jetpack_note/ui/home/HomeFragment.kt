package com.hankkin.jetpack_note.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hankkin.jetpack_note.databinding.FragmentHomeBinding
import com.hankkin.jetpack_note.utils.InjectorUtils

class HomeFragment : Fragment() {

    private val viewModel: HomeListViewModel by viewModels {
        InjectorUtils.provideHomeListViewModelFactory(requireContext())
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return FragmentHomeBinding.inflate(inflater, container, false).root
    }

}