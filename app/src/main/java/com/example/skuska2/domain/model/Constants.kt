package com.example.skuska2.domain.model

import com.example.skuska2.R
import org.mongodb.kbson.ObjectId

object Constants {
    const val USERNAME: String = "user_name"
    private lateinit var username: String
    private lateinit var usernameID: ObjectId

    fun setUsername(usernameP: String) {
        username = usernameP
    }

    fun getUsername(): String {
        return username
    }

    fun setUsernameID(usernameP: ObjectId) {
        usernameID = usernameP
    }

    fun getUsernameID(): ObjectId {
        return usernameID
    }
}