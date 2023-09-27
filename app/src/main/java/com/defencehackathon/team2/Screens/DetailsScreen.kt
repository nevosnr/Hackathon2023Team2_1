package com.defencehackathon.team2.Screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.defencehackathon.team2.customAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
//Recommendations Screen
fun DetailScreen(drawerState: DrawerState){
    Scaffold (
        topBar = {customAppBar(
            drawerState = drawerState,
            title = "Recommendations Page"
        )}
    ){ paddingValues ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
        ) {
            Text(text = "Recommendations")
        }
    }

}