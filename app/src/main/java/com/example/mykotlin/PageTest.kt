package com.example.mykotlin

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun PageTest(navController: NavController) {

    TextField(
        modifier = Modifier
//            .fillMaxWidth()
            .fillMaxHeight()
            .width(100.dp)
            .widthIn()
            .heightIn(min = 56.dp),
        value = "",
        onValueChange = {},
        placeholder = { Text("placeholder-Search") }
    )

}