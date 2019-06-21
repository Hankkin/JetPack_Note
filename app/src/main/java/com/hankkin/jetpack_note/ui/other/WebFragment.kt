package com.hankkin.jetpack_note.ui.other

import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.hankkin.jetpack_note.R
import com.hankkin.jetpack_note.widget.CoolIndicatorLayout
import com.hankkin.jetpack_note.databinding.FragmentWebBinding
import com.hankkin.jetpack_note.ext.clipTxt
import com.hankkin.jetpack_note.ext.snackBarShow
import com.hankkin.jetpack_note.utils.CommonUtils
import com.just.agentweb.AgentWeb
import com.just.agentweb.AgentWebSettingsImpl
import com.just.agentweb.DefaultWebClient
import kotlinx.android.synthetic.main.activity_main.*

class WebFragment : Fragment() {

    private val args: WebFragmentArgs by navArgs()
    private lateinit var mAgentWeb: AgentWeb
    private lateinit var binding: FragmentWebBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        binding = FragmentWebBinding.inflate(inflater, container, false)
        requireActivity().toolbar.title = args.title
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initWeb()
    }

    private fun initWeb() {
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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.web_menu, menu)
        menu.findItem(R.id.action_settings).isVisible = false
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_share -> CommonUtils.share(requireActivity(), args.link)
            R.id.action_website -> CommonUtils.openBrowser(requireActivity(), args.link)
            R.id.action_copy -> {
                requireActivity().clipTxt(args.link)
                requireActivity().snackBarShow(binding.llCommonWeb, getString(R.string.clip_hint))
            }
            else -> {
                return false
            }
        }
        return super.onOptionsItemSelected(item)
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