package com.hankkin.jetpack_note.ui.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.hankkin.jetpack_note.R
import com.hankkin.jetpack_note.databinding.FragmentNavigationBinding

class NavigationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentNavigationBinding.inflate(inflater, container, false)
        clickEvent(binding)
        return binding.root
    }

    private fun clickEvent(binding: FragmentNavigationBinding) {
        binding.btnNav.setOnClickListener {
            findNavController().navigate(R.id.navSampleActivity)
        }
        binding.btnBottom.setOnClickListener {
            findNavController().navigate(R.id.bottomNavSampleActivity)
        }
    }
}