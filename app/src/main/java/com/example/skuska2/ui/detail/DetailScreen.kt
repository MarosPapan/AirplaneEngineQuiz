package com.example.skuska2.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.skuska2.R
import com.example.skuska2.Screen
import com.example.skuska2.domain.model.setData
import com.example.skuska2.ui.components.TopBarQuiz
import com.example.skuska2.ui.theme.md_theme_light_onPrimaryContainer
import com.example.skuska2.ui.theme.md_theme_light_primary
import com.example.skuska2.views.CategoriesView
import com.example.skuska2.views.DetailView
import org.mongodb.kbson.ObjectId

@Composable
fun DetailScreen(navController: NavController, typeOfEngine: String, modifier: Modifier = Modifier){
    val viewModel = viewModel<DetailView>()
    //var engine = viewModel.getEngine1(id)
    var engine = viewModel.getEngineByName(typeOfEngine)

    Scaffold(
        topBar ={ TopBarQuiz() }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxHeight()
                .padding(paddingValues)
                .background(md_theme_light_primary)
        ) {
            item{
                ElevatedCard(
                modifier = modifier
                    .padding(15.dp),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(md_theme_light_onPrimaryContainer),
                    horizontalAlignment = Alignment.CenterHorizontally

                ) {
                    Image(
                        painter = painterResource(id = viewModel.getImageByName(typeOfEngine)),
                        contentDescription = viewModel.getEngineByName(typeOfEngine)?.typeOfEngine,
                        modifier = Modifier
                            .size(120.dp)
                            .padding(10.dp)
                    )
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            modifier = Modifier.padding(0.dp),
                            text = viewModel.getEngineByName(typeOfEngine)?.typeOfEngine.toString(),
                            style = MaterialTheme.typography.headlineLarge,
                            color = Color.White,
                        )

                        Image(
                            painter = painterResource(R.drawable.underline),
                            contentDescription = "spacer line",
                            modifier = Modifier
                                .height(15.dp)
                                .width(50.dp)

                        )
                        Text(
                            modifier = Modifier.padding(bottom = 10.dp),
                            text = "ENGINE",
                            style = MaterialTheme.typography.labelSmall,
                            color = Color.White
                        )
                    }


                }

            }
            }

            item {
                ElevatedCard(
                modifier = modifier
                    .padding(top = 0.dp, bottom = 15.dp, end = 15.dp, start = 15.dp),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(md_theme_light_onPrimaryContainer),
                    horizontalAlignment = Alignment.Start

                ) {
                    Column(
                    ) {
                        Text(
                            modifier = Modifier.padding(10.dp),
                            text = "Basic information about engine",
                            style = MaterialTheme.typography.labelSmall,
                            textDecoration = TextDecoration.Underline,
                            color = Color.White,

                            )
                        Text(
                            modifier = Modifier.padding(start = 10.dp, top = 0.dp, bottom = 10.dp, end = 10.dp),
                            text = viewModel.getEngineByName(typeOfEngine)?.description.toString(),
                            style = MaterialTheme.typography.labelSmall,
                            color = Color.White
                        )
                    }


                }

            } }

            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(
                        onClick = { navController.navigate(Screen.QuizScreen.route + "/" + typeOfEngine) },
                        shape = RoundedCornerShape(topStart = 10.dp, bottomEnd = 20.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = md_theme_light_onPrimaryContainer
                        )
                        )
                    {
                        Text(
                            text = "Start quiz",
                            style = MaterialTheme.typography.labelMedium,
                            color = Color.White
                        )
                    }
                }

            }

        }
    }
}



@Preview
@Composable
fun DetailScreenPreview(){
    DetailScreen(navController = rememberNavController(), "TurboProp")
}