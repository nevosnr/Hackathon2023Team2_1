@file:OptIn(ExperimentalMaterial3Api::class)

package com.defencehackathon.team2.ui.theme.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun EditUserDetails(
    value: String,
    onValueChange: (String) -> Unit,
    label: String = "",
    leadingIconImage: ImageVector,
    leadingIconDescription:String,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    showError: Boolean = false,
    errorMessage: String = ""

){
    Column (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        OutlinedTextField(
            value = value,
            onValueChange = {onValueChange(it)},
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(bottom = 10.dp),
            label = { Text(label)},
            leadingIcon = {
                Icon(
                    imageVector = leadingIconImage,
                    contentDescription = leadingIconDescription,
                    tint = if(showError) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurface )
            },
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            singleLine = true
        )
    }
}