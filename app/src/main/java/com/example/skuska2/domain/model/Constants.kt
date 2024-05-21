package com.example.skuska2.domain.model

import com.example.skuska2.R
import org.mongodb.kbson.ObjectId

object Constants {
    private lateinit var username: String

    fun setUsername(usernameP: String) {
        username = usernameP
    }

    fun getUsername(): String {
        return username
    }
}