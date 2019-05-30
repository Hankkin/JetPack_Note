package com.hankkin.jetpack_note.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hankkin.jetpack_note.databinding.FragmentNavigationBinding

class NavigationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return FragmentNavigationBinding.inflate(inflater, container, false).root
    }
}