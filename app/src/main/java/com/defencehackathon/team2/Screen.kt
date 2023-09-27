package com.defencehackathon.team2

sealed class Screen(val route:String)

    object CMainScreen : Screen("Main_Screen")
    object CDetailScreen : Screen("Detail_Screen")



