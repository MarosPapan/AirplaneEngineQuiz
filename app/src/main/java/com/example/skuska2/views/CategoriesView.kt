package com.example.skuska2.views

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.skuska2.MyApp
import com.example.skuska2.domain.model.Engine
import com.example.skuska2.domain.model.setData
import com.example.skuska2.models.Person
import com.example.skuska2.models.Score
import io.realm.kotlin.ext.query
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch


class CategoriesView: ViewModel() {
    private val realm = MyApp.realm

    val engineList1 = realm
        .query<com.example.skuska2.models.Engine>()
        .asFlow()
        .map {
        results -> results.list.toList()
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(),
            emptyList()
        )

    fun getPerson(name: String): Person?{
        return realm.query<Person>(query = "name == $0", name).first().find()
    }

    fun deleteCategory(category: com.example.skuska2.models.Engine) {
        viewModelScope.launch {
            realm.write {
                val category = category ?: return@write
                val latestCategory = findLatest(category) ?: return@write
                delete(category)
            }
        }
    }
}



