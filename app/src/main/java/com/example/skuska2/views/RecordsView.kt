package com.example.skuska2.views

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.skuska2.MyApp
import com.example.skuska2.models.Person
import com.example.skuska2.models.Score
import io.realm.kotlin.ext.query
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import org.mongodb.kbson.ObjectId

class RecordsView: ViewModel() {
    private val realm = MyApp.realm
    var name = mutableStateOf("")
    var score = mutableStateOf("")
    var filtered = mutableStateOf(false)
    var data = mutableStateOf(emptyList<Score>())
    var objectId = mutableStateOf("")

    init {
        viewModelScope.launch { getData().collect{
            data.value = it
        } }
    }

    private fun getData(): Flow<List<Score>> {
        return realm.query<Score>().asFlow().map { it.list }
    }

    private fun filteredData(name: String): Flow<List<Score>>{
        return realm.query<Score>(query = "person.name CONTAINS[c] $0", name).asFlow().map { it.list }
    }

    suspend fun deleteScore(id: ObjectId) {
        realm.write {
            val score = query<Score>(query = "id == $0", id).first().find()
            try {
                score?.let { delete(it) }
            }catch (e: Exception) {
                Log.d("MongoRepositoryImpl", "${e.message}")
            }
        }
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
                getData().collect {
                    filtered.value = false
                    name.value = ""
                    data.value = it
                }
            }
            else {
                filteredData(name = name.value).collect {
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
                deleteScore(id = ObjectId(hexString = objectId.value))
            }
        }
    }
}