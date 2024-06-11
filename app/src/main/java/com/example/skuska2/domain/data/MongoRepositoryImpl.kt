package com.example.skuska2.domain.data

import android.util.Log
import com.example.skuska2.models.Engine
import com.example.skuska2.models.Person
import com.example.skuska2.models.Quiz
import com.example.skuska2.models.Score
import io.realm.kotlin.Realm
import io.realm.kotlin.UpdatePolicy
import io.realm.kotlin.ext.query
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.mongodb.kbson.ObjectId

class MongoRepositoryImpl(val realm: Realm) : MongoRepository {
    override fun getAllEngines(): Flow<List<Engine>> {
        return realm.query<Engine>().asFlow().map { it.list }
    }

    override fun getEngineById(id: ObjectId): Engine? {
        return realm.query<Engine>(query = "id == $0", id).first().find()
    }

    override fun getEngineByName(name: String): Engine? {
        var engine: Engine?
        engine = realm.query<Engine>(query = "typeOfEngine == $0", name).first().find()
        println(engine?.typeOfEngine)
        return  engine
    }

    override fun getPersonByName(name: String): Person? {
        return realm.query<Person>(query = "name == $0", name).first().find()
    }

    override fun getPersonById(id: ObjectId): Person? {
        return realm.query<Person>(query = "id == $0", id).first().find()
    }

    override suspend fun deletePerson(id: ObjectId) {
        realm.write {
            val person = query<Person>(query = "id == $0", id).first().find()
            try {
                person?.let { delete(it) }
            }catch (e: Exception) {
                Log.d("MongoRepositoryImpl", "${e.message}")
            }
        }
    }

    override fun getAllUsers(): Flow<List<Person>> {
        return realm.query<Person>().asFlow().map { it.list }
    }

    override fun filteredUsers(name: String): Flow<List<Person>> {
        return realm.query<Person>(query = "name CONTAINS[c] $0", name).asFlow().map { it.list }
    }

    override suspend fun insertPerson(person: Person) {
        realm.write { copyToRealm(person) }
    }

    override fun getQuestionsByEngine(typeOfEngine: String): Quiz {
        var engine = getEngineByName(typeOfEngine)
        var quiz: Quiz?
        quiz = realm.query<Quiz>(query = "quizOfEngine.id == $0", engine?.id).first().find()
        if (quiz != null) {
            println("Up until now working: " + typeOfEngine + quiz.questions.get(1).question)
            return quiz
        }else{
            print("Went to else")
            return Quiz()
        }
    }

    override fun getQuizByEngine(name: String): Quiz?{
        var quiz: Quiz?
        quiz = realm.query<Quiz>(query = "quizOfEngine.typeOfEngine == $0", name).first().find()
        println(quiz?.quizOfEngine?.typeOfEngine.toString())
        return quiz
    }

    override fun getAllScores(): Flow<List<Score>> {
        return realm.query<Score>().asFlow().map { it.list }
    }

    override fun filteredScores(name: String): Flow<List<Score>> {
        return realm.query<Score>(query = "person.name CONTAINS[c] $0", name).asFlow().map { it.list }
    }

    override suspend fun deleteScore(id: ObjectId) {
        realm.write {
            val score = query<Score>(query = "id == $0", id).first().find()
            try {
                score?.let { delete(it) }
            }catch (e: Exception) {
                Log.d("MongoRepositoryImpl", "${e.message}")
            }
        }
    }

    override suspend fun insertScore(person: Person, quiz: Quiz, scoreP: Int) {
        realm.write{
            val score1 = Score().apply {
                score = scoreP
            }
            score1.person = findLatest(person)
            score1.quiz = findLatest(quiz)
            copyToRealm(score1, updatePolicy = UpdatePolicy.ALL)
        }
    }

    override fun getScoresByName(name: String): Flow<List<Score>> {
        return realm.query<Score>(query = "person.name == $0", name).asFlow().map { it.list }
    }
}