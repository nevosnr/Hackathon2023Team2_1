package com.defencehackathon.team2.Screens

import android.inputmethodservice.Keyboard
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.defencehackathon.team2.customAppBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
//Recommendations Screen
fun MainScreen(drawerState: DrawerState,
               buttonSpacing: Dp = 8.dp,){

    Scaffold (
        topBar = {customAppBar(
            drawerState = drawerState,
            title = "My Career"
        )}
    ){ paddingValues ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
        ) {
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .weight(1f)
                    ) {
                    Text(text = "All",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center)
                }
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .weight(1f)
                ) {
                    Text(text = "training",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center)
                }
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .weight(1f)
                ) {
                    Text(text = "Events",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center)
                }
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .weight(1f)
                ) {
                    Text(text = "Jobs",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center)
                }

            }
            Text(text = "Lazy Column to go here!")
        }
    }

}