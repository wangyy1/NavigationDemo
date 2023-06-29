package com.example.navigationdemo.demo1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import com.example.navigationdemo.R


class TwoFragment : Fragment() {

    private var userId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            userId = it.getString("userId")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_two_demo1, container, false)
        view.findViewById<Button>(R.id.btn1).setOnClickListener {
            view.findNavController().navigate(R.id.action_twoFragment_to_threeActivity)
        }
        view.findViewById<Button>(R.id.btn2).setOnClickListener {
//            view.findNavController().navigate(R.id.action_twoFragment_pop)
        }
        view.findViewById<Button>(R.id.btn3).setOnClickListener {
            val navOptions = NavOptions.Builder()
                .setEnterAnim(R.anim.slide_in_right_enter)
                .setExitAnim(R.anim.slide_out_left_exit)
                .setPopEnterAnim(R.anim.slide_in_left_pop_enter)
                .setPopExitAnim(R.anim.slide_out_right_pop_exit)
                .build()
            view.findNavController().navigate(
                R.id.action_twoFragment_to_threeFragment,
                null,
                navOptions
            )
        }
        return view
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(context, "$userId", Toast.LENGTH_SHORT).show()
    }
}