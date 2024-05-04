package com.example.skuska2.views

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WelcomeView : ViewModel() {
    var text by mutableStateOf("")
        private set
    var openDialog by mutableStateOf(false)
    fun setValue(value: String){
        text = value
    }

    fun onDismissAlertDialog() {
        openDialog = false
    }

    fun onOpenAlertDialog() {
        openDialog = true
    }
}