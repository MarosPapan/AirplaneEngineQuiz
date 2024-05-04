package com.example.skuska2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.skuska2.domain.model.setData
import com.example.skuska2.ui.categories.CategoriesScreen
import com.example.skuska2.ui.theme.Skuska2Theme
import com.example.skuska2.views.WelcomeView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Skuska2Theme {
                // A surface container using the 'background' color from the theme
                //CategoriesScreen()
               //setData.SetEnginesData()
                Navigation()
            }
        }
    }
}

