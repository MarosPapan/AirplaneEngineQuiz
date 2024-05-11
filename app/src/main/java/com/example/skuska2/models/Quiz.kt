package com.example.skuska2.models

import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.BsonObjectId
import org.mongodb.kbson.ObjectId

class Quiz: RealmObject {
    @PrimaryKey var id: ObjectId = ObjectId()
    var questions: RealmList<Question> = realmListOf()
    var quizOfEngine: Engine? = null
}