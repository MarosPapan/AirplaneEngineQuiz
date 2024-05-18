package com.example.skuska2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.skuska2.ui.theme.Skuska2Theme
import com.example.skuska2.views.MainViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            //viewModel.createSampleEntries()
            Skuska2Theme {
                // A surface container using the 'background' color from the theme
                Navigation()
            }
        }
    }
}

