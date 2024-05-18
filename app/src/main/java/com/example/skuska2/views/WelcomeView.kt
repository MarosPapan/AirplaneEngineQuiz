package com.example.skuska2.views

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.skuska2.MyApp
import com.example.skuska2.models.Person
import com.example.skuska2.models.Score
import io.realm.kotlin.ext.query
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import org.mongodb.kbson.ObjectId
import java.util.Locale

class WelcomeView : ViewModel() {
    private val realm = MyApp.realm
    var text by mutableStateOf("")
        private set
    var openDialog by mutableStateOf(false)
    var nameAlreadyExistDialog by mutableStateOf(false)
    fun setValue(value: String){
        text = value
    }

    fun onDismissAlertDialog() {
        openDialog = false
    }

    fun onOpenAlertDialog() {
        openDialog = true
    }

    suspend fun insertPerson(person: Person) {
        realm.write { copyToRealm(person) }
    }

    fun addPerson() {
        viewModelScope.launch(Dispatchers.IO) {
            if(text.isNotEmpty()) {
                insertPerson(person = Person().apply {
                    name = text
                })
            }
        }
    }

    suspend fun updatePerson(person: Person) {
        realm.write {
            val queriedPerson = realm.query<Person>(query = "id == $0", person.id).first().find()
            queriedPerson?.name = person.name
        }
    }

    fun nameAlreadyExist(name: String): Boolean {
        val queriedPerson = realm.query<Person>(query = "name == $0", name).first().find()
        if (queriedPerson?.name.toString().lowercase() == name.lowercase()) {
            nameAlreadyExistDialog = true
        }else{
            nameAlreadyExistDialog = false
        }
        return nameAlreadyExistDialog
    }

    fun onDismisNameExist() {
        this.nameAlreadyExistDialog = false
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
}