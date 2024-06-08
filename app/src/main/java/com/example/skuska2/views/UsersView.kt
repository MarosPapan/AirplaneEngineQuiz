package com.example.skuska2.views

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.skuska2.domain.di.DatabaseModule
import com.example.skuska2.models.Person
import com.example.skuska2.models.Score
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import org.mongodb.kbson.ObjectId

class UsersView: ViewModel() {
    private val realm = DatabaseModule.provideRealm()
    private val repository = DatabaseModule.provideMongoRepository(realm)

    var name = mutableStateOf("")
    var filtered = mutableStateOf(false)
    var data = mutableStateOf(emptyList<Person>())
    var objectId = mutableStateOf("")
    var signingIn = mutableStateOf(false)
    var onDeleteDialog = mutableStateOf(false)


    init {
        viewModelScope.launch {
            repository.getAllUsers().collect {
                data.value = it
            }
        }
    }

    fun updateName(name: String) {
        this.name.value = name
    }

    fun updateObjectID(id: String) {
        this.objectId.value = id
    }


    fun filterData() {
        viewModelScope.launch(Dispatchers.IO) {
            if (filtered.value) {
                repository.getAllUsers().collect {
                    filtered.value = false
                    name.value = ""
                    data.value = it
                }
            } else {
                repository.filteredUsers(name = name.value).collect {
                    filtered.value = true
                    data.value = it
                }
            }
        }
    }

    fun removeUser(id: String, name: String) {
        updateObjectID(id)
        setSigningIn(false)
        val personToRemove = repository.getPersonById(ObjectId(hexString = objectId.value))
        viewModelScope.launch {
            if (objectId.value.isNotEmpty() && (personToRemove?.name.toString() != name)){
                removeScoreByName(personToRemove?.name.toString())
                repository.deletePerson(id = ObjectId(hexString = objectId.value))
            } else {
                onOpenDeleteDialog()
            }
        }
    }

    fun removeScoreByName(name: String) {
        val scoresToDelete: Flow<List<Score>> = repository.getScoresByName(name)
        viewModelScope.launch {
            scoresToDelete.collect{
                    scores ->
                for (score in scores){
                    repository.deleteScore(id = score.id)
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