package com.hankkin.jetpack_note.ui.navigation.fg


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.hankkin.jetpack_note.R
import com.hankkin.jetpack_note.data.Component
import kotlinx.android.synthetic.main.fragment_sample_home.*

/**
 * A simple [Fragment] subclass.
 *
 */
class SampleHomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sample_home, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()
        //jump
        btn_nav_sample_jump.setOnClickListener {
            navController.navigate(R.id.action_homeSampleFragment_to_dashBoardSampleFragment)
        }
        //jump with action
        btn_nav_sample_jump_action.setOnClickListener {
            navController.navigate(R.id.action_homeSampleFragment_to_dashBoardSampleFragment_action)
        }


        val component = Component("1","我是传递过来实体类Component类型参数","","")
        //基本类型跳转
        btn_nav_sample_jump_argument_normal.setOnClickListener {
            val directions =
                SampleHomeFragmentDirections.actionHomeSampleFragmentToArgsSampleFragment(
                    0,
                    "我是传递过来基本类型String参数",
                    component
                )
            navController.navigate(directions)
        }
        //自定义实体类型跳转  注意 实体类需要序列化
        btn_nav_sample_jump_argument_bean.setOnClickListener {
            val directions =
                SampleHomeFragmentDirections.actionHomeSampleFragmentToArgsSampleFragment(
                    1,
                    "",
                    component
                )
            navController.navigate(directions)
        }
    }

}
