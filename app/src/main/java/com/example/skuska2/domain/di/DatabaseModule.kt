package com.example.skuska2.domain.di

import com.example.skuska2.domain.data.MongoRepository
import com.example.skuska2.domain.data.MongoRepositoryImpl
import com.example.skuska2.models.Engine
import com.example.skuska2.models.Person
import com.example.skuska2.models.Question
import com.example.skuska2.models.Quiz
import com.example.skuska2.models.Score
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import javax.inject.Singleton


@InstallIn(SingletonComponent:: class)
@Module
object DatabaseModule {

    @Singleton
    @Provides
    fun provideRealm(): Realm {
        val config = RealmConfiguration.Builder(
            schema = setOf(
                Engine::class,
                Person::class,
                Question::class,
                Quiz::class,
                Score::class,
            )
        )
            .compactOnLaunch() //will optimize the size of database whenever the app is launched
       //     .initialData()
            .build()
        return Realm.open(config)
    }
    @Singleton
    @Provides
    fun provideMongoRepository(realm: Realm): MongoRepository {
        return MongoRepositoryImpl(realm = realm)
    }
}