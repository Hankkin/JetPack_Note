package com.hankkin.jetpack_note.ui.navigation.fg


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.hankkin.jetpack_note.R
import kotlinx.android.synthetic.main.fragment_sample_dashboard.*

/**
 * A simple [Fragment] subclass.
 *
 */
class SampleDashboardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sample_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_nav_dashboard_jump.setOnClickListener {
            findNavController().navigate(R.id.action_dashBoardSampleFragment_to_notificationSampleFragment)
        }
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
    }

}
