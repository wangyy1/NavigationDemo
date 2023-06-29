package com.example.navigationdemo.demo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavType
import androidx.navigation.Navigator
import androidx.navigation.createGraph
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.fragment
import androidx.navigation.get
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.navigationdemo.R
import com.google.android.material.appbar.CollapsingToolbarLayout
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

/**
 * 使用 Kotlin DSL 定义导航图，代码动态定义
 */
class MainActivity : AppCompatActivity() {

    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_demo2)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        navHostFragment.navController.apply {
            graph = createGraph(nav_graph.id, nav_graph.dest.home) {
                fragment<HomeViewPagerFragment>(nav_graph.dest.home) {
                    label = "Home"
                    action(nav_graph.action.to_plant_detail) {
                        destinationId = nav_graph.dest.plant_detail
                    }
                }
                fragment<PlantDetailFragment>(nav_graph.dest.plant_detail) {
                    label = "Detail"
                    argument(nav_graph.args.plant_id) {
                        type = NavType.StringType
                    }
                }
            }
        }
    }
}




//class CustomNavigator : Navigator<NavDestination>() {
//    override fun createDestination(): NavDestination {
//        TODO("Not yet implemented")
////        NavDestination("").ar
//    }
//
//}


class MainViewModel : ViewModel() {

    private val _dataFlow = MutableSharedFlow<String>()

    val dataFlow = _dataFlow.asSharedFlow()

    fun sendData(data: String) {
        viewModelScope.launch {
            _dataFlow.emit(data)
        }
    }


    private val timeFlow = flow {
        var time = 0
        while (true) {
            emit(time)
            kotlinx.coroutines.delay(1000)
            time++
        }
    }

    val stateFlow = timeFlow.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        0
    )
}