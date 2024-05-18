package com.example.skuska2.views

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.skuska2.domain.di.DatabaseModule
import com.example.skuska2.models.Score
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.mongodb.kbson.ObjectId

class RecordsView: ViewModel() {
    private val realm = DatabaseModule.provideRealm()
    private val repository = DatabaseModule.provideMongoRepository(realm)
    var name = mutableStateOf("")
    var score = mutableStateOf("")
    var filtered = mutableStateOf(false)
    var data = mutableStateOf(emptyList<Score>())
    var objectId = mutableStateOf("")

    init {
        viewModelScope.launch { repository.getAllScores().collect{
            data.value = it
        } }
    }

    fun updateName(name: String) {
        this.name.value = name
    }

    fun updateScore(score: String) {
        this.score.value = score
    }

    fun filterData() {
        viewModelScope.launch (Dispatchers.IO)   {
            if (filtered.value) {
                repository.getAllScores().collect {
                    filtered.value = false
                    name.value = ""
                    data.value = it
                }
            }
            else {
                repository.getScoresByName(name = name.value).collect {
                    filtered.value = true
                    data.value = it
                }
            }
        }
    }

    fun updateObjectID(id: String) {
        this.objectId.value = id
    }
    fun removeScore(id: String) {
        updateObjectID(id)
        viewModelScope.launch {
            if (objectId.value.isNotEmpty()){
                repository.deleteScore(id = ObjectId(hexString = objectId.value))
            }
        }
    }
}