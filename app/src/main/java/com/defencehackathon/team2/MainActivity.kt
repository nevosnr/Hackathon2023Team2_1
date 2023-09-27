@file:OptIn(ExperimentalMaterial3Api::class)

package com.defencehackathon.team2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.SportsFootball
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.defencehackathon.team2.Screens.DetailScreen
import com.defencehackathon.team2.Screens.GoalsScreen
import com.defencehackathon.team2.Screens.MainScreen
import com.defencehackathon.team2.Screens.ProfileScreen
import com.defencehackathon.team2.Screens.SearchScreen
import com.defencehackathon.team2.Screens.SettingsScreen
import com.defencehackathon.team2.ui.theme.Hackathon2023Team2_1Theme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            Hackathon2023Team2_1Theme {
                MainNavigation()
            }
        }
    }
}

data class DrawerMenu(
    val icon: ImageVector,
    val title: String,
    //val selectedIcon: ImageVector,
    //val unselectedIcon: ImageVector,
    //val badgeCount: Int? = null,
    val route: String
)

enum class MainRoute(value: String) {
    MainScreen("MainScreen"),
    DetailsScreen("Recomendations"),
    ProfileScreen("Profile"),
    SearchScreen("Search"),
    GoalsScreen("Goals"),
    SettingsScreen("Settings")
}

val menus = arrayOf(
    DrawerMenu(Icons.Filled.AccountCircle, "Profile Screen", MainRoute.ProfileScreen.name),
    DrawerMenu(Icons.Filled.Search, "Search Screen", MainRoute.SearchScreen.name),
    DrawerMenu(Icons.Filled.AccountBalanceWallet, "Search Screen", MainRoute.DetailsScreen.name),
    DrawerMenu(Icons.Filled.SportsFootball, "Goals Screen", MainRoute.GoalsScreen.name),
    DrawerMenu(Icons.Filled.Send, "Home Screen", MainRoute.MainScreen.name),
    DrawerMenu(Icons.Filled.Settings, "Settings Screen", MainRoute.SettingsScreen.name),
)

@Composable
fun MainNavigation(
    navController: NavHostController = rememberNavController(),
    crScope: CoroutineScope = rememberCoroutineScope(),
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
) {
    ModalNavigationDrawer(drawerState = drawerState, drawerContent = {
        ModalDrawerSheet {
            DrawerContent(menus = menus) { route ->
                crScope.launch { drawerState.close() }
                navController.navigate(route)

            }
        }
    }) {
        NavHost(
            navController = navController,
            startDestination = MainRoute.MainScreen.name
        ) {
            composable(
                route = MainRoute.MainScreen.name,

                ) {
                MainScreen(drawerState)
            }
            composable(
                route = MainRoute.DetailsScreen.name
            ) {
                DetailScreen(drawerState)
            }
            composable(
                route = MainRoute.ProfileScreen.name
            ) {
                ProfileScreen(drawerState)
            }
            composable(
                route = MainRoute.SettingsScreen.name
            ) {
                SettingsScreen(drawerState)
            }
            composable(
                route = MainRoute.GoalsScreen.name
            ) {
                GoalsScreen(drawerState)
            }
            composable(
                route = MainRoute.SearchScreen.name
            ) {
                SearchScreen(drawerState)
            }
        }

    }
}