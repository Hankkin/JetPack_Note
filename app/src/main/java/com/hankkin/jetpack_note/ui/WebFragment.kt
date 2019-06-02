package com.hankkin.jetpack_note.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.hankkin.jetpack_note.component.CoolIndicatorLayout
import com.hankkin.jetpack_note.databinding.FragmentWebBinding
import com.just.agentweb.AgentWeb
import com.just.agentweb.AgentWebSettingsImpl
import com.just.agentweb.DefaultWebClient
import kotlinx.android.synthetic.main.activity_main.*

class WebFragment : Fragment() {

    private val args: WebFragmentArgs by navArgs()
    private lateinit var mAgentWeb: AgentWeb


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentWebBinding.inflate(inflater, container, false);
        requireActivity().toolbar.title = args.title
        initWeb(binding)
        return binding.root
    }

    private fun initWeb(binding: FragmentWebBinding) {
        mAgentWeb = AgentWeb.with(this)
            .setAgentWebParent(binding.webView, LinearLayout.LayoutParams(-1, -1))
            .setCustomIndicator(CoolIndicatorLayout(context))
            .setAgentWebWebSettings(AgentWebSettingsImpl.getInstance())
            .setSecurityType(AgentWeb.SecurityType.STRICT_CHECK)
            .interceptUnkownUrl()
            .setOpenOtherPageWays(DefaultWebClient.OpenOtherPageWays.ASK)
            .createAgentWeb()
            .go(args.link)

    }


    override fun onDestroy() {
        super.onDestroy()
        mAgentWeb.webLifeCycle.onDestroy()
    }

    override fun onResume() {
        super.onResume()
        mAgentWeb.webLifeCycle.onResume()
    }

}