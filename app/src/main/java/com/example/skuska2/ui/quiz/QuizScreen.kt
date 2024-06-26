package com.example.skuska2.ui.quiz

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.skuska2.Screen
import com.example.skuska2.ui.components.AlertDialog
import com.example.skuska2.ui.components.AnswerButton
import com.example.skuska2.ui.theme.md_theme_light_onPrimaryContainer
import com.example.skuska2.ui.theme.md_theme_light_primary
import com.example.skuska2.ui.theme.md_theme_light_surface
import com.example.skuska2.views.QuizView


@Composable
fun QuizScreen(navController: NavController, typeOfEngine: String) {
    val viewModel = viewModel<QuizView>()
    Scaffold(
        topBar ={ }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxHeight()
                .padding(paddingValues)
                .background(md_theme_light_primary),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            item{
                ElevatedCard(
                    modifier = Modifier
                        .padding(15.dp),
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(md_theme_light_onPrimaryContainer),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceEvenly

                    ) {
                        Image(
                            painter = painterResource(id = viewModel.getImageByName(typeOfEngine)),
                            contentDescription = viewModel.getEngineByName(typeOfEngine)?.typeOfEngine,
                            modifier = Modifier
                                .size(120.dp)
                                .padding(10.dp)
                        )
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Text(
                                modifier = Modifier.padding(bottom = 10.dp),
                                text = viewModel.getEngineByName(typeOfEngine)?.typeOfEngine + " Quiz",
                                style = MaterialTheme.typography.headlineLarge,
                                color = Color.White,
                            )
                        }
                    }
                }
            }

            item{
                ElevatedCard(
                    modifier = Modifier
                        .padding(15.dp),
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(md_theme_light_onPrimaryContainer),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceEvenly

                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Text(
                                modifier = Modifier.padding(bottom = 10.dp, top = 10.dp),
                                text = "Actual score:",
                                style = MaterialTheme.typography.headlineMedium,
                                color = Color.White,
                            )
                            Text(
                                modifier = Modifier.padding(bottom = 10.dp),
                                text = viewModel.getScore1().toString() + " / " + viewModel.getSizeOfQuiz(typeOfEngine = typeOfEngine),
                                style = MaterialTheme.typography.headlineLarge,
                                color = Color.White,
                            )
                        }
                        if (viewModel.openDialog) {
                            AlertDialog(onDismiss = {viewModel.onDismissAlertDialog()}, message = "You have not selected the option", buttonText = "Select option")
                        }
                    }
                }
            }

            item {
                ElevatedCard(
                    modifier = Modifier
                        .padding(top = 15.dp, bottom = 15.dp, end = 15.dp, start = 15.dp),
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(md_theme_light_onPrimaryContainer),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceEvenly

                    ) {
                        Text(
                            modifier = Modifier.padding(15.dp).align(Alignment.Start),
                            text = "Question: " + (viewModel.getNumberOfQuestion1()+1).toString(),
                            color = Color.White,
                            style = MaterialTheme.typography.headlineSmall
                        )
                        //Displaying questions
                        Text(
                            modifier = Modifier.padding(15.dp),
                            text = viewModel.getQuestionsByName(typeOfEngine).questions.get(viewModel.getNumberOfQuestion1()).question,
                            color = Color.White
                        )
                        AnswerButton(
                            colorOFButton = viewModel.backgroundColorOFAnswer1,
                            answerText = viewModel.getQuestionsByName(typeOfEngine).questions.get(viewModel.getNumberOfQuestion1()).optionOne,
                            numberOfAnswer = 1,
                            modifier = Modifier
                                .padding(start = 10.dp, end = 10.dp, bottom = 10.dp),
                            onClickFunction = {
                                viewModel.changeBackgroundColor1(
                                    1,
                                    viewModel.getQuestionsByName(typeOfEngine).questions.get(viewModel.getNumberOfQuestion1()).correctAnswer
                                )
                            }
                        )

                        AnswerButton(
                            colorOFButton = viewModel.backgroundColorOFAnswer2,
                            answerText = viewModel.getQuestionsByName(typeOfEngine).questions.get(viewModel.getNumberOfQuestion1()).optionTwo,
                            numberOfAnswer = 2,
                            modifier = Modifier
                                .padding(start = 10.dp, end = 10.dp, bottom = 10.dp),
                            onClickFunction = {
                                viewModel.changeBackgroundColor1(
                                    2,
                                    viewModel.getQuestionsByName(typeOfEngine).questions.get(viewModel.getNumberOfQuestion1()).correctAnswer
                                )
                            }
                        )

                        AnswerButton(
                            colorOFButton = viewModel.backgroundColorOFAnswer3,
                            answerText = viewModel.getQuestionsByName(typeOfEngine).questions.get(viewModel.getNumberOfQuestion1()).optionThree,
                            numberOfAnswer = 3,
                            modifier = Modifier
                                .padding(start = 10.dp, end = 10.dp, bottom = 10.dp),
                            onClickFunction = {
                                viewModel.changeBackgroundColor1(
                                    3,
                                    viewModel.getQuestionsByName(typeOfEngine).questions.get(viewModel.getNumberOfQuestion1()).correctAnswer
                                )
                            }

                        )
                    }
                }

                if(viewModel.getNumberOfQuestion1() < viewModel.getSizeOfQuiz(typeOfEngine = typeOfEngine)-1){
                    Button(
                        onClick = { viewModel.nextQuestionButton() },
                        modifier = Modifier.padding(15.dp),
                        shape = RoundedCornerShape(topStart = 10.dp, bottomEnd = 10.dp, bottomStart = 10.dp, topEnd = 10.dp),
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = 10.dp,
                            pressedElevation = 6.dp
                        ),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = md_theme_light_primary
                        ),
                        border = BorderStroke(2.dp, md_theme_light_surface)
                    ) {
                        Text(
                            text = "Next question",
                            color = Color.White
                        )
                    }
                } else if(viewModel.getNumberOfQuestion1() == viewModel.getSizeOfQuiz(typeOfEngine = typeOfEngine)-1) {
                    Button(
                        onClick = {if(viewModel.getClickedOption1())navController.navigate(route = Screen.ResultScreen.passIdScoreNumbQuest(typeOfEngine = typeOfEngine, score = viewModel.getScore1(), numbQuest = viewModel.getSizeOfQuiz(typeOfEngine))) else viewModel.onOpenAlertDialog()},
                        modifier = Modifier.padding(15.dp),
                        shape = RoundedCornerShape(topStart = 10.dp, bottomEnd = 10.dp, bottomStart = 10.dp, topEnd = 10.dp),
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = 10.dp,
                            pressedElevation = 6.dp
                        ),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = md_theme_light_primary
                        ),
                        border = BorderStroke(2.dp, md_theme_light_surface)
                    ) {
                        Text(
                            text = "Show result",
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
fun QuizScreenPreview(){
    QuizScreen(navController = rememberNavController(), "TurboProp")
}