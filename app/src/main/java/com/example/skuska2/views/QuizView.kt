package com.example.skuska2.views

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.skuska2.R
import com.example.skuska2.domain.di.DatabaseModule
import com.example.skuska2.models.Engine
import com.example.skuska2.models.Quiz

class QuizView: ViewModel() {

    private val realm = DatabaseModule.provideRealm()
    private val repository = DatabaseModule.provideMongoRepository(realm)

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

    fun getEngineByName(name: String): Engine?{
        return repository.getEngineByName(name)
    }

    fun getImageByName(name: String): Int{
        return getEngineByName(name)?.image?.toInt() ?: R.drawable.propeller
    }

    //in this function use getEngineById
    fun getQuestionsByName(typeOfEngine: String): Quiz {
        return repository.getQuestionsByEngine(typeOfEngine)
    }

    fun getSizeOfQuiz(typeOfEngine: String): Int {
        return getQuestionsByName(typeOfEngine)?.questions?.size ?: 0
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

    fun nextQuestionButton() {
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