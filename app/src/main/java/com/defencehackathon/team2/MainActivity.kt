@file:OptIn(ExperimentalMaterial3Api::class)

package com.defencehackathon.team2

import android.annotation.SuppressLint
import android.os.Bundle
import android.service.autofill.OnClickAction
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Create
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.internal.composableLambda
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.PathNode
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.defencehackathon.team2.Screens.DetailScreen
import com.defencehackathon.team2.Screens.MainScreen
import com.defencehackathon.team2.ui.theme.Hackathon2023Team2_1Theme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            Hackathon2023Team2_1Theme {}
        }
    }
}

data class DrawerMenu(
    val icon: ImageVector, val title: String,
    //val selectedIcon: ImageVector,
    //val unselectedIcon: ImageVector,
    //val badgeCount: Int? = null,
    val route: String
)

enum class MainRoute(value: String) {
    MainScreen("MainScreen"), DetailsScreen("DetailScreen")
}

val menus = arrayOf(
    DrawerMenu(Icons.Filled.Send, "Main Screen", MainRoute.MainScreen.name),
    DrawerMenu(Icons.Filled.AccountBalanceWallet, "Details Screen", MainRoute.DetailsScreen.name)
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
        }

    }
}