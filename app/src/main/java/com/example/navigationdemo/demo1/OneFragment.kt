package com.example.navigationdemo.demo1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.net.toUri
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.example.navigationdemo.R


class OneFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_one_demo1, container, false)

        val btn1 = view.findViewById<Button>(R.id.btn1)

        btn1.setOnClickListener {
            // 方式一
//            view.findNavController()
//                .navigate(
//                    R.id.action_oneFragment_to_twoFragment,
//                    bundleOf("userid" to "9527")
//                )
            FragmentNavigatorExtras()
            // 方式二 使用 Safe Args 插件方式
            val action = OneFragmentDirections.actionOneFragmentToTwoFragment("9527")
            view.findNavController().navigate(action)
        }
        return view
    }
}