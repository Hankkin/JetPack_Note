package com.hankkin.jetpack_note.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hankkin.jetpack_note.databinding.FragmentCodeBinding
import com.hankkin.jetpack_note.databinding.FragmentLifecyclesBinding

class CodeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentCodeBinding.inflate(inflater, container, false).root
    }
}