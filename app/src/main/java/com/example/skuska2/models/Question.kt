package com.example.skuska2.models

import io.realm.kotlin.types.EmbeddedRealmObject
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.BsonObjectId
import org.mongodb.kbson.ObjectId

//maybe embeddedObject
class Question: RealmObject {
    @PrimaryKey var id: ObjectId = ObjectId()
    var question: String = ""
    var optionOne: String = ""
    var optionTwo: String = ""
    var optionThree: String = ""
    var correctAnswer: Int = 0
    var image: Int = 0
    var engine: Engine? = null
}