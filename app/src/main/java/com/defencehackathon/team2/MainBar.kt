@file:OptIn(ExperimentalMaterial3Api::class)

package com.defencehackathon.team2

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource


@Composable
fun MainBar(
    onNavigationIconClick:()-> Unit
){
    TopAppBar(title = {
            Text(text = "R.string.app_name)")
        },
        //backgroundColor
        //contentColor
        navigationIcon = {
            IconButton(onClick = onNavigationIconClick) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "Drawer Toggle")

            }
        }
    )
}
