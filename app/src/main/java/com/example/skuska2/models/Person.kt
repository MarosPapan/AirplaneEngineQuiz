package com.example.skuska2.models

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId

class Person: RealmObject {
    @PrimaryKey var id: ObjectId = ObjectId() //from mongoDb there is alse from realm if some mistake look at this
    var name: String = ""
    var surname: String = ""
}