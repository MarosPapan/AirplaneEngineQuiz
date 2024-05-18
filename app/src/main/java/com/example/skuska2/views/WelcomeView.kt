package com.example.skuska2.views

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.skuska2.domain.di.DatabaseModule
import com.example.skuska2.models.Person
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class WelcomeView: ViewModel() {
    private val realm = DatabaseModule.provideRealm()
    private val repository = DatabaseModule.provideMongoRepository(realm)

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


    fun addPerson() {
        viewModelScope.launch(Dispatchers.IO) {
            if(text.isNotEmpty()) {
                repository.insertPerson(person = Person().apply {
                    name = text
                })
            }
        }
    }

    fun nameAlreadyExist(name: String): Boolean {
        val queriedPerson = repository.getPersonByName(name)
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

}