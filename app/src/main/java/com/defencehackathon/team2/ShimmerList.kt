package com.defencehackathon.team2

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntSize

@Composable
fun ShimmerListItem(
    isLoading: Boolean,
    contentAfterLoading : @Composable () -> Unit,
    modifier: Modifier = Modifier
){

}

//fun Modifier.shimmerEffect(): Modifier = composed{
//    var size = remember{ mutableStateOf(IntSize.Zero}
//}