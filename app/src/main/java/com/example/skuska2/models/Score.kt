package com.example.skuska2.models

import io.realm.kotlin.types.EmbeddedRealmObject
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId


class Score: RealmObject {
    @PrimaryKey var id: ObjectId = ObjectId()
    var score: Int = 0
    var engine: Engine? = null
    var person: Person? = null
}