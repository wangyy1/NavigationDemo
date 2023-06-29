package com.example.navigationdemo.demo1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.navigationdemo.R


class ThreeFragment : Fragment() {

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
        val view = inflater.inflate(R.layout.fragment_three_demo1, container, false)
        view.findViewById<Button>(R.id.btn1).setOnClickListener {
            view.findNavController().navigate(R.id.action_threeFragment_pop)
        }
        return view
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(context, "$userId", Toast.LENGTH_SHORT).show()
    }
}