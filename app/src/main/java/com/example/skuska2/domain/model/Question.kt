package com.example.skuska2.domain.model

data class Question(
    val id: Int,
    val question: String,
    val optionOne: String,
    val optionTwo: String,
    val optionThree: String,
    val correctAnswer: Int,
    val image: Int
)
