package com.example.skuska2

const val ENGINE_ARGUMENT_KEY = "id"
const val SCORE_ARGUMENT_KEY = "score"
const val NUMBER_OF_QUESTIONS = "numbQuest"

sealed class Screen(val route: String) {
    object CategoriesScreen: Screen("categories_screen")
    object WelcomeScreen: Screen("welcome_screen")
    object DetailScreen: Screen("detail_screen")
    object QuizScreen: Screen("quiz_screen")
    object ResultScreen: Screen("result_screen/{$ENGINE_ARGUMENT_KEY}/{$SCORE_ARGUMENT_KEY}/{$NUMBER_OF_QUESTIONS}"){
//        fun passId(id: Int): String{
//            return this.route.replace(oldValue = "{$ENGINE_ARGUMENT_KEY}", newValue = id.toString())
//        }
        fun passIdScoreNumbQuest(id: Int, score: Int, numbQuest: Int): String {
            return "result_screen/$id/$score/$numbQuest"
        }
    }
}