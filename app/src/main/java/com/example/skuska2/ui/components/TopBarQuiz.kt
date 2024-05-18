package com.example.skuska2.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.skuska2.ui.theme.md_theme_light_onPrimaryContainer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarQuiz() {
    CenterAlignedTopAppBar(
        modifier = Modifier
            .fillMaxWidth()
        ,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = md_theme_light_onPrimaryContainer
        ),
        title = {
            Text(
                modifier = Modifier,
                text = "Airplane Engines",
                style = MaterialTheme.typography.headlineLarge,
                color = Color.White
            )

        }
    )
}