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
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import org.mongodb.kbson.ObjectId

class UsersView: ViewModel() {
    private val realm = MyApp.realm
    var name = mutableStateOf("")
    var filtered = mutableStateOf(false)
    var data = mutableStateOf(emptyList<Person>())
    var objectId = mutableStateOf("")
    var signingIn = mutableStateOf(false)
    var onDeleteDialog = mutableStateOf(false)


    init {
        viewModelScope.launch {
            getData().collect {
                data.value = it
            }
        }
    }

    private fun getData(): Flow<List<Person>> {
        return realm.query<Person>().asFlow().map { it.list }
    }

    private fun filteredData(name: String): Flow<List<Person>> {
        return realm.query<Person>(query = "name CONTAINS[c] $0", name).asFlow().map { it.list }
    }

    fun updateName(name: String) {
        this.name.value = name
    }

    fun updateObjectID(id: String) {
        this.objectId.value = id
    }

    suspend fun deletePerson(id: ObjectId) {
        realm.write {
            val person = query<Person>(query = "id == $0", id).first().find()
            try {
                person?.let { delete(it) }
            }catch (e: Exception) {
                Log.d("MongoRepositoryImpl", "${e.message}")
            }
        }
    }

    fun filterData() {
        viewModelScope.launch(Dispatchers.IO) {
            if (filtered.value) {
                getData().collect {
                    filtered.value = false
                    name.value = ""
                    data.value = it
                }
            } else {
                filteredData(name = name.value).collect {
                    filtered.value = true
                    data.value = it
                }
            }
        }
    }

    private fun getScoresByName(name: String): Flow<List<Score>> {
        return realm.query<Score>(query = "person.name == $0", name).asFlow().map { it.list }
    }

    //this is not working
    fun removeUser(id: String, name: String) {
        updateObjectID(id)
        setSigningIn(false)
        val personToRemove = realm.query<Person>(query = "id == $0", ObjectId(hexString = objectId.value)).first().find()
        removeScoreByName(personToRemove?.name.toString())
        viewModelScope.launch {
            if (objectId.value.isNotEmpty() && (personToRemove?.name.toString() != name)){
                deletePerson(id = ObjectId(hexString = objectId.value))
            } else {
                onOpenDeleteDialog()
            }
        }
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

    fun removeScoreByName(name: String) {
        val scoresToDelete: Flow<List<Score>> = getScoresByName(name)
        viewModelScope.launch {
            scoresToDelete.collect{
                    scores ->
                for (score in scores){
                    deleteScore(id = score.id)
                }
            }

        }
    }

    fun getSigningIn(): Boolean {
        return signingIn.value
    }

    fun setSigningIn(value: Boolean) {
        this.signingIn.value = value
    }

    fun onOpenDeleteDialog() {
        this.onDeleteDialog.value = true
    }

    fun onCloseDeleteDialog() {
        this.onDeleteDialog.value = false
    }
}