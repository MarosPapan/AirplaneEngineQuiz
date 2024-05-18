package com.example.skuska2.views

import androidx.lifecycle.ViewModel
import com.example.skuska2.domain.di.DatabaseModule
import com.example.skuska2.models.Engine
import com.example.skuska2.models.Person
import kotlinx.coroutines.flow.Flow

class CategoriesView: ViewModel() {
    private val realm = DatabaseModule.provideRealm()
    private val repository = DatabaseModule.provideMongoRepository(realm)

    fun getListOfEngines(): Flow<List<Engine>> {
        return repository.getAllEngines()
    }

    fun getPerson(name: String): Person?{
        return repository.getPersonByName(name)
    }
}



