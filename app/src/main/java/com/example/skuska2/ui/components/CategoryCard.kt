package com.example.skuska2.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.skuska2.Screen
import com.example.skuska2.models.Engine
import com.example.skuska2.ui.theme.md_theme_light_onPrimaryContainer


@Composable
fun CategoryCard(
    navController: NavController,
    modifier: Modifier = Modifier,
    category: Engine,
    onClickFunction: () -> Unit
) {
    ElevatedCard(
        modifier = modifier
            .padding(15.dp)
            .clickable { navController.navigate(Screen.DetailScreen.route + "/" + category.typeOfEngine) },
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(md_theme_light_onPrimaryContainer),
            verticalAlignment = Alignment.CenterVertically
        ) {

                Image(
                    painter = painterResource(category.image),
                    contentDescription = category.typeOfEngine,
                    modifier = Modifier
                        .size(120.dp)
                        .padding(10.dp)
            )
            Column {
                Text(
                    modifier = Modifier.padding(5.dp),
                    text = category.typeOfEngine,
                    style = MaterialTheme.typography.headlineLarge,
                    color = Color.White
                )
                Text(
                    modifier = Modifier.padding(5.dp),
                    text = "Discover more +",
                    style = MaterialTheme.typography.labelSmall,
                    color = Color.White
                )
                Text(
                    modifier = Modifier.padding(5.dp),
                    text = category.id.toString(),
                    style = MaterialTheme.typography.labelSmall,
                    color = Color.White
                )
            }


        }
    }
}


@Preview
@Composable
fun CategoryCardPreview(){
    CategoryCard(navController = rememberNavController(), category = Engine(), onClickFunction = {})
}