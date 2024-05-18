package com.example.skuska2

const val TYPE_OF_ENGINE = "typeOfEngine"
const val SCORE_ARGUMENT_KEY = "score"
const val NUMBER_OF_QUESTIONS = "numbQuest"

sealed class Screen(val route: String) {
    object CategoriesScreen: Screen("categories_screen")
    object WelcomeScreen: Screen("welcome_screen")
    object DetailScreen: Screen("detail_screen")
    object QuizScreen: Screen("quiz_screen")
    object ResultScreen: Screen("result_screen/{$TYPE_OF_ENGINE}/{$SCORE_ARGUMENT_KEY}/{$NUMBER_OF_QUESTIONS}"){

        fun passIdScoreNumbQuest(typeOfEngine: String, score: Int, numbQuest: Int): String {
            return "result_screen/$typeOfEngine/$score/$numbQuest"
        }
    }
    object RecordsScreen: Screen("records_screen")
    object UsersScreen: Screen("users_screen")
}