package com.example.skuska2.views

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.skuska2.R
import com.example.skuska2.domain.di.DatabaseModule
import com.example.skuska2.models.Engine
import com.example.skuska2.models.Person
import com.example.skuska2.models.Quiz
import kotlinx.coroutines.launch

class ResultView: ViewModel() {
    private val realm = DatabaseModule.provideRealm()
    private val repository = DatabaseModule.provideMongoRepository(realm)
    var score2 = mutableStateOf(0)
    var typeOfEngine = mutableStateOf("")
    var name = mutableStateOf("")
    var onRecordResult = mutableStateOf(false)
    var failRecord = mutableStateOf(false)

    fun getEngineByName(name: String): Engine?{
        return repository.getEngineByName(name)
    }

    fun getPerson(name: String): Person?{
        return repository.getPersonByName(name)
    }

    fun getQuizByEngine(name: String): Quiz? {
        return repository.getQuizByEngine(name)
    }

    fun getImageByName(name: String): Int{
        return getEngineByName(name)?.image?.toInt() ?: R.drawable.propeller
    }

    fun addScore1() {
        val personToWrite: Person? = getPerson(name.value)
        val quizToWrite: Quiz? = getQuizByEngine(typeOfEngine.value)
        if (personToWrite != null && quizToWrite != null) {
            viewModelScope.launch {
                repository.insertScore(personToWrite, quizToWrite, score2.value)
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