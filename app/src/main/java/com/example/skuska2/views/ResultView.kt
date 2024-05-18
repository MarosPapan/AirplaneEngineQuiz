package com.example.skuska2.views

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.skuska2.MyApp
import com.example.skuska2.R
import com.example.skuska2.domain.model.Constants
import com.example.skuska2.models.Engine
import com.example.skuska2.models.Person
import com.example.skuska2.models.Quiz
import com.example.skuska2.models.Score
import io.realm.kotlin.UpdatePolicy
import io.realm.kotlin.ext.query
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch

class ResultView: ViewModel() {
    private val realm = MyApp.realm
    var score2 = mutableStateOf(0)
    var typeOfEngine = mutableStateOf("")
    var name = mutableStateOf("")
    var onRecordResult = mutableStateOf(false)
    var failRecord = mutableStateOf(false)

    fun getEngineByName(name: String): Engine?{
        var engine: Engine?
        engine = realm.query<Engine>(query = "typeOfEngine == $0", name).first().find()
        println(engine?.typeOfEngine)
        return  engine
    }

    fun getPerson(name: String): Person?{
        var person: Person?
        person = realm.query<Person>(query = "name == $0", name).first().find()
        println(person?.name)
        return  person
    }

    fun getQuizByEngine(name: String): Quiz? {
        var quiz: Quiz?
        quiz = realm.query<Quiz>(query = "quizOfEngine.typeOfEngine == $0", name).first().find()
        println(quiz?.quizOfEngine?.typeOfEngine.toString())
        return quiz
    }

    fun getImageByName(name: String): Int{
        return getEngineByName(name)?.image?.toInt() ?: R.drawable.propeller
    }

    suspend fun insertScore(score: Score) {
        realm.write { copyToRealm(score) }
    }

    fun addScore() {
        val personToWrite: Person? = getPerson(name.value)
        val quizToWrite: Quiz? = getQuizByEngine(typeOfEngine.value)
        if (personToWrite != null && quizToWrite != null) {
            viewModelScope.launch(Dispatchers.IO) {
            }
            viewModelScope.launch(Dispatchers.IO) {
                insertScore(score = Score().apply {
                    score = score2.value
                    person = personToWrite
                    quiz = quizToWrite
                })
                onOpenRecordedDialog()
            }
        }else {
            println(personToWrite?.name.toString())
            println(quizToWrite?.quizOfEngine?.typeOfEngine.toString())
            onOpenFailRecordDialog()
        }
    }

    fun addScore1() {
        val personToWrite: Person? = getPerson(name.value)
        val quizToWrite: Quiz? = getQuizByEngine(typeOfEngine.value)
        if (personToWrite != null && quizToWrite != null) {
            viewModelScope.launch {
                realm.write{
                    val score = Score().apply {
                        score = score2.value
                    }
                    score.person = findLatest(personToWrite)
                    score.quiz = findLatest(quizToWrite)
                    copyToRealm(score, updatePolicy = UpdatePolicy.ALL)
                }
                onOpenRecordedDialog()
            }
        } else {
            onOpenFailRecordDialog()
            Log.w("e", personToWrite?.name.toString() + " " + quizToWrite?.quizOfEngine?.typeOfEngine.toString())
        }

    }

    fun getName1(): String{
        return this.name.value
    }
    fun setName1(name: String){
        this.name.value = name
    }

    fun getTypeOfEngine1(): String{
        return this.typeOfEngine.value
    }
    fun setTypeOfEngine1(name: String){
        this.typeOfEngine.value = name
    }

    fun getScore1(): Int{
        return this.score2.value
    }
    fun setScore1(score: Int){
        this.score2.value = score
    }

    fun onOpenRecordedDialog() {
        onRecordResult.value = true
    }

    fun onDismissRecordedDialog() {
        onRecordResult.value = false
    }

    fun onOpenFailRecordDialog() {
        failRecord.value = true
    }

    fun onDismissFailRecordDialog() {
        failRecord.value = false
    }

}