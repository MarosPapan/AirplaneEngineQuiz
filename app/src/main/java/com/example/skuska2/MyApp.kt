package com.example.skuska2

import android.app.Application
import com.example.skuska2.domain.di.DatabaseModule
import com.example.skuska2.models.Engine
import com.example.skuska2.models.Person
import com.example.skuska2.models.Question
import com.example.skuska2.models.Quiz
import com.example.skuska2.models.Score
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.types.TypedRealmObject
import kotlin.reflect.KClass

class MyApp: Application() {
    companion object{
        lateinit var realm: Realm
    }


    //here use DatabaseModule

    override fun onCreate() {
        super.onCreate()
        realm = DatabaseModule.provideRealm()
        DatabaseModule.provideMongoRepository(realm)
    }
}