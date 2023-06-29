package com.example.navigationdemo.demo2

object nav_graph {
    const val id = 1

    object dest {
        const val home = 2
        const val plant_detail = 3
    }

    object action {
        const val to_plant_detail = 4
    }

    object args {
        const val plant_id = "plantId"
    }
}