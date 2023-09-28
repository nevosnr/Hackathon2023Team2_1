package com.defencehackathon.team2.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.defencehackathon.team2.customAppBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
//Recommendations Screen
fun GoalsScreen(drawerState: DrawerState){
    Scaffold (
        topBar = {customAppBar(
            drawerState = drawerState,
            title = "Goals Page"
        )}
    ){ paddingValues ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
        ) {
            Text(text = "Goals Screen",
                textAlign = TextAlign.Center)
        }
    }

}