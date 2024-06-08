package com.example.skuska2.domain.model


object Constants {
    private lateinit var username: String

    fun setUsername(usernameP: String) {
        username = usernameP
    }

    fun getUsername(): String {
        return username
    }
}