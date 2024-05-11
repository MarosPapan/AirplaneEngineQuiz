package com.example.skuska2

import android.app.Application
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

    override fun onCreate() {
        super.onCreate()
        realm = Realm.open(
            configuration = RealmConfiguration.create(
                schema = setOf(
                    Engine::class,
                    Person::class,
                    Question::class,
                    Quiz::class,
                    Score::class,
                )
            )
        )
    }
}