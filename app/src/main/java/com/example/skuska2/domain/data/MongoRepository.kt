package com.example.skuska2.domain.data

import com.example.skuska2.models.Engine
import com.example.skuska2.models.Person
import com.example.skuska2.models.Quiz
import com.example.skuska2.models.Score
import kotlinx.coroutines.flow.Flow
import org.mongodb.kbson.ObjectId

interface MongoRepository {
    fun getAllEngines(): Flow<List<Engine>>
    fun getEngineById(id: ObjectId): Engine?
    fun getEngineByName(name: String): Engine?

    fun getPersonByName(name: String): Person?
    fun getPersonById(id: ObjectId): Person?
    suspend fun deletePerson(id: ObjectId)
    fun getAllUsers(): Flow<List<Person>>
    fun filteredUsers(name: String): Flow<List<Person>>
    suspend fun insertPerson(person: Person)

    fun getQuestionsByEngine(typeOfEngine: String): Quiz
    fun getQuizByEngine(name: String): Quiz?

    fun getAllScores(): Flow<List<Score>>
    fun filteredScores(name: String): Flow<List<Score>>
    suspend fun deleteScore(id: ObjectId)
    suspend fun insertScore(person: Person, quiz: Quiz, scoreP: Int)
    fun getScoresByName(name: String): Flow<List<Score>>
}