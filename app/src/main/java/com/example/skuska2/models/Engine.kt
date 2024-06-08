package com.example.skuska2.models

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId

class Engine: RealmObject {
    @PrimaryKey var id: ObjectId = ObjectId()
    var typeOfEngine: String = ""
    var description: String = ""
    var image: Int = 0
}