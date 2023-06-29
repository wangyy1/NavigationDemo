package com.example.navigationdemo.demo2

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.navigationdemo.R
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch


private const val TAG = "HomeViewPagerFragment"
class HomeViewPagerFragment : Fragment() {

    private val mainViewModel by activityViewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_view, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Toolbar>(R.id.toolbar).setupWithNavController(findNavController())

        view.findViewById<Button>(R.id.btn1).setOnClickListener {
            val args = bundleOf(nav_graph.args.plant_id to "1")
            findNavController().navigate(nav_graph.action.to_plant_detail, args)
        }

        view.findViewById<Button>(R.id.btn2).setOnClickListener {
            lifecycleScope.launch {
               for (i in 0..10) {
                   mainViewModel.sendData("第一条数据 $i")
               }
            }
        }


        view.findViewById<Button>(R.id.btn3).setOnClickListener {
            job?.cancel()
            job = lifecycleScope.launch {
                mainViewModel.dataFlow.collect {
                    Log.d(TAG, "onViewCreated: $it")
                }
            }
        }
    }
    private var job : Job? = null
}