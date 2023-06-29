package com.example.navigationdemo.demo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.navigationdemo.R
import com.google.android.material.appbar.CollapsingToolbarLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 示例一
//        setContentView(R.layout.activity_main_demo1)
//        val navHostFragment =
//            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container_view) as NavHostFragment
//        val navController = navHostFragment.findNavController()
//        val appBarConfiguration = AppBarConfiguration(navController.graph)
//        // 使用下面这个方式第一个页面也会显示返回按钮
////        val appBarConfiguration = AppBarConfiguration(topLevelDestinationIds = setOf(), fallbackOnNavigateUpListener = ::onSupportNavigateUp)
//        findViewById<Toolbar>(R.id.toolbar).setupWithNavController(navController, appBarConfiguration)

        // 示例二
        setContentView(R.layout.activity_main_demo2)
//        val layout = findViewById<CollapsingToolbarLayout>(R.id.collapsing_toolbar_layout)
//        val toolbar = findViewById<Toolbar>(R.id.toolbar)
//        val navHostFragment =
//            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container_view) as NavHostFragment
//        val navController = navHostFragment.navController
//
//        val appBarConfiguration = AppBarConfiguration(navController.graph)
//        layout.setupWithNavController(toolbar, navController, appBarConfiguration)

    }
}