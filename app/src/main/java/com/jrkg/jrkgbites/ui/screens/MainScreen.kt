package com.jrkg.jrkgbites.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MainScreen() {
    // This is the "container" where your dragged items will land
    Column {
        Text(text = "Start your design here!")
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    // This function allows the 'Design' and 'Split' tabs to work
    MainScreen()
}