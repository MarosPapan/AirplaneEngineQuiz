package com.example.skuska2.ui.categories

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.sharp.AccountCircle
import androidx.compose.material.icons.sharp.ArrowBack
import androidx.compose.material.icons.twotone.AccountCircle
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.skuska2.R
import com.example.skuska2.Screen
import com.example.skuska2.domain.model.Engine
import com.example.skuska2.domain.model.setData
import com.example.skuska2.ui.components.CategoryCard
import com.example.skuska2.ui.theme.md_theme_light_onPrimaryContainer
import com.example.skuska2.ui.theme.md_theme_light_primary
import com.example.skuska2.views.CategoriesView
import com.example.skuska2.views.WelcomeView
import java.util.Locale.Category

@Composable
fun CategoriesScreen(navController: NavController, name: String) {
    val viewModel = viewModel<CategoriesView>()
    viewModel.initializeEngineList()
    Scaffold(
        topBar = {CategoriesScreenTopBar()}
    ) {paddingValues ->
        LazyColumn (
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(md_theme_light_primary)
        ) {
            item {
                CategoryCardSection(
                    navController = navController,
                    modifier = Modifier.fillMaxSize(),
                    categoryList = viewModel.getEngineList1(),
                    name = name
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable private fun CategoriesScreenTopBar() {
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

@Composable
private fun CategoryCardSection(
    navController: NavController,
    modifier: Modifier,
    categoryList: List<Engine>,
    emptyListText: String = "You don't have any categories",
    name: String
) {
    Column (modifier = modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
        ) {
            Text(
                text = " Type of Engine:",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 12.dp),
                color = Color.Black,
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End,
            ) {
                IconButton(
                    onClick = { /*TODO*/ },
                ) {
                    Icon(
                        imageVector = Icons.Sharp.AccountCircle,
                        contentDescription = "Add category",
                    )
                }
                Text(
                    text = name,
                    modifier = Modifier.padding(10.dp),
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Black
                )
            }

        }
        if (categoryList.isEmpty()) {
            Image(
                modifier = Modifier
                    .size(60.dp)
                    .align(Alignment.CenterHorizontally),
                painter = painterResource(R.drawable.airplane),
                contentDescription = emptyListText
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = emptyListText,
                style = MaterialTheme.typography.bodySmall,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }



        for (category in categoryList){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.Center),
                horizontalArrangement = Arrangement.spacedBy(12.dp),

            ) {
                CategoryCard(
                    navController = navController,
                    categoryName = category.typeOfEngine,
                    categoryImage = category.image,
                    categoryID = category.id
              ) {}
            }
        }

        IconButton(
            onClick = { navController.navigate(Screen.WelcomeScreen.route) },
        ) {
            Icon(
                imageVector = Icons.Sharp.ArrowBack,
                contentDescription = "Add category",
            )
        }
    }
}

@Preview
@Composable
fun CategoriesScreenPreview(){
    setData.SetEnginesData()
    CategoriesScreen(navController = rememberNavController(), name = "Michael")
}
