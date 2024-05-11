package com.example.skuska2

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavType
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.skuska2.ui.WelcomeScreen
import com.example.skuska2.ui.categories.CategoriesScreen
import com.example.skuska2.ui.detail.DetailScreen
import com.example.skuska2.ui.quiz.QuizScreen
import com.example.skuska2.ui.results.ResultScreen
import com.example.skuska2.views.WelcomeView
import org.mongodb.kbson.BsonObjectId
import org.mongodb.kbson.ObjectId

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.WelcomeScreen.route) {
        composable(route = Screen.WelcomeScreen.route) {
            WelcomeScreen(navController = navController, modifier = Modifier)
        }
       composable(
           route = Screen.CategoriesScreen.route + "/{name}",
           arguments = listOf(
               navArgument("name"){
                   type = NavType.StringType
               }
           )
       ) { entry ->
           val name = entry.arguments?.getString("name").toString()

           CategoriesScreen(navController = navController, name = name)
       }
        composable(
            route = Screen.DetailScreen.route + "/{typeOfEngine}",
            arguments = listOf(
                navArgument("typeOfEngine"){
                    type = NavType.StringType
                }
            )
        ) { entry ->
            val typeOfEngine = entry.arguments?.getString("typeOfEngine").toString()
            DetailScreen(navController = navController, typeOfEngine = typeOfEngine)
        }

        composable(
            route = Screen.QuizScreen.route + "/{typeOfEngine}",
            arguments = listOf(
                navArgument("typeOfEngine"){
                    type = NavType.StringType
                }
            )
        ) { entry ->
            val typeOfEngine = entry.arguments?.getString("typeOfEngine").toString()

            QuizScreen(navController = navController, typeOfEngine = typeOfEngine)
        }

        composable(
            route = Screen.ResultScreen.route,
            arguments = listOf(
                navArgument(TYPE_OF_ENGINE){
                    type = NavType.StringType
                },
                navArgument(SCORE_ARGUMENT_KEY){
                    type = NavType.IntType
                },
                navArgument(NUMBER_OF_QUESTIONS){
                    type = NavType.IntType
                }
            )
        ) { entry ->
            val typeOfEngine = entry.arguments?.getString(TYPE_OF_ENGINE).toString()
            val score = entry.arguments?.getInt(SCORE_ARGUMENT_KEY).toString()
            val numberOfQuestions = entry.arguments?.getInt(NUMBER_OF_QUESTIONS).toString()

            ResultScreen(navController = navController, typeOfEngine = typeOfEngine, score = score.toInt(), numberofQuestions = numberOfQuestions.toInt())
        }

    }
}

