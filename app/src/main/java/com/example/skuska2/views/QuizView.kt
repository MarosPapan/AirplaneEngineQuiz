package com.example.skuska2.views

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.navigation.compose.rememberNavController
import com.example.skuska2.domain.model.Constants
import com.example.skuska2.domain.model.Question
import com.example.skuska2.ui.results.ResultScreen

class QuizView: ViewModel() {

    private var numberOfQuestion by mutableIntStateOf(0)
    private var clickedOption by mutableStateOf(false)
    private var score by mutableIntStateOf(0)
    var openDialog by mutableStateOf(false)

    var backgroundColorOFAnswer1 by mutableStateOf(Color.Blue)
        private set

    var backgroundColorOFAnswer2 by mutableStateOf(Color.Blue)
        private set

    var backgroundColorOFAnswer3 by mutableStateOf(Color.Blue)
        private set


    fun getNumberOfQuestion1(): Int{
        return numberOfQuestion
    }

    fun getRightQuestions(id: Int): List<Question>{
        var mQuestionList: List<Question> = emptyList()
        when(id){
            1 -> {mQuestionList = Constants.getTurboPropQuestions()}
            2 -> {mQuestionList = Constants.getTurboFunQuestions()}
            3 -> {mQuestionList = Constants.getTurboJetQuestions()}
            4 -> {mQuestionList = Constants.getTurboshaftQuestions()}
        }
        return mQuestionList
    }

    fun changeBackgroundColor1(userSelection: Int, rightOption: Int){
        if (!clickedOption) {
            when (userSelection) {
                1 -> {
                    if (userSelection == rightOption){
                        backgroundColorOFAnswer1 = Color.Green
                        score += 1
                    }
                    else if (rightOption == 2) {
                        backgroundColorOFAnswer2 = Color.Green
                        backgroundColorOFAnswer1 = Color.Red
                    }
                    else if(rightOption == 3) {
                        backgroundColorOFAnswer3 = Color.Green
                        backgroundColorOFAnswer1 = Color.Red
                    }
                }
                2 -> {
                    if (userSelection == rightOption){
                        backgroundColorOFAnswer2 = Color.Green
                        score += 1
                    }
                    else if (rightOption == 1) {
                        backgroundColorOFAnswer1 = Color.Green
                        backgroundColorOFAnswer2 = Color.Red
                    }
                    else if(rightOption == 3) {
                        backgroundColorOFAnswer3 = Color.Green
                        backgroundColorOFAnswer2 = Color.Red
                    }
                }
                3 -> {
                    if (userSelection == rightOption){
                        backgroundColorOFAnswer3 = Color.Green
                        score += 1
                    }
                    else if (rightOption == 2) {
                        backgroundColorOFAnswer2 = Color.Green
                        backgroundColorOFAnswer3 = Color.Red
                    }
                    else if(rightOption == 1) {
                        backgroundColorOFAnswer1 = Color.Green
                        backgroundColorOFAnswer3 = Color.Red
                    }
                }
            }
        }
        clickedOption = true

        Log.i( "Information", "Button clicked")
    }

    fun setNumberOfQuestion1(number: Int) {
        numberOfQuestion = number
    }

    fun nextQuestionButton(idOfEngine: Int) {
        if(clickedOption == true){
            setNumberOfQuestion1(getNumberOfQuestion1()+1)
            backgroundColorOFAnswer1 = Color.Blue
            backgroundColorOFAnswer2 = Color.Blue
            backgroundColorOFAnswer3 = Color.Blue
            clickedOption = false
        }else{
            onOpenAlertDialog()
        }

    }

    fun getScore1(): Int {
        return score
    }
    fun getClickedOption1(): Boolean {
        return clickedOption
    }

    fun onDismissAlertDialog() {
        openDialog = false
    }

    fun onOpenAlertDialog() {
        openDialog = true
    }

}