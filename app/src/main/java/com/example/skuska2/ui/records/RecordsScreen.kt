package com.example.skuska2.ui.records

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.skuska2.Screen
import com.example.skuska2.domain.model.Constants
import com.example.skuska2.ui.components.TopBarQuiz
import com.example.skuska2.ui.theme.md_theme_light_onPrimaryContainer
import com.example.skuska2.ui.theme.md_theme_light_primary
import com.example.skuska2.views.RecordsView


@Composable
fun RecordsScreen(navController: NavController) {
    val viewModel = viewModel<RecordsView>()


    Scaffold(
        topBar ={ TopBarQuiz() }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxHeight()
                .padding(paddingValues)
                .background(md_theme_light_primary)

        ) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.White),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Text(
                        text = "Records of taken quizes",
                        style = MaterialTheme.typography.headlineLarge,
                        modifier = Modifier.padding(start = 12.dp),
                        color = Color.Black,
                    )
                }

                IconButton(
                    onClick = { navController.navigate(Screen.CategoriesScreen.route+"/"+Constants.getUsername()) },
                ) {
                    Icon(
                        imageVector = Icons.Sharp.ArrowBack,
                        contentDescription = "Add category",
                    )
                }

                Row(
                    modifier = Modifier.padding(start = 5.dp, end = 5.dp, top=5.dp )
                ) {
                    TextField(
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 5.dp),
                        value = viewModel.name.value,
                        onValueChange = viewModel::updateName,
                        placeholder = { Text(text = "Name") },
                        singleLine = true
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    TextField(
                        modifier = Modifier.weight(1f),
                        value = viewModel.score.value,
                        onValueChange = viewModel::updateScore,
                        placeholder = { Text(text = "Score") },
                        singleLine = true
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                }
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(state = rememberScrollState()),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Spacer(modifier = Modifier.width(6.dp))
                    Button(onClick = { viewModel.filterData() }) {
                        Text(text = if(viewModel.filtered.value) "Clear" else "Filter")
                    }
                }
                Spacer(modifier = Modifier.height(24.dp))
            }
            items(items = viewModel.data.value, key = {it.id.toHexString()}) {
                ScoreView(
                    id = it.id.toHexString(),
                    name = it.person?.name.toString(),
                    score = it.score,
                    typeOfEngine = it.quiz?.quizOfEngine?.typeOfEngine.toString(),
                    onClickFunction = {viewModel.removeScore(it.id.toHexString())}
                )
            }
        }
    }
}


@Composable
fun ScoreView(id: String, name: String, score: Int, typeOfEngine: String, onClickFunction: () -> Unit){
    Row(
        modifier = Modifier.padding(bottom = 24.dp)
    ) {
        Column(
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = score.toString(),
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "$typeOfEngine Quiz",
                style = MaterialTheme.typography.bodyMedium
            )
            Button(
                onClick = onClickFunction,
                shape = RoundedCornerShape(topStart = 10.dp, bottomEnd = 20.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = md_theme_light_onPrimaryContainer
                )
            ){
                Text(
                    text = "Delete score",
                    style = MaterialTheme.typography.labelMedium,
                    color = Color.White
                )
            }
        }
    }
}

@Preview
@Composable
fun RecordsScreenPreview(){
    RecordsScreen(navController = rememberNavController())
}
