package com.example.skuska2.views

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.skuska2.MyApp
import com.example.skuska2.domain.model.Engine
import com.example.skuska2.domain.model.setData
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

    fun deleteCategory(category: com.example.skuska2.models.Engine) {
        viewModelScope.launch {
            realm.write {
                val category = category ?: return@write
                val latestCategory = findLatest(category) ?: return@write
                delete(category)
            }
        }
    }

//    fun initializeEngineList() {
//        engineList1.value.toList()
//        if(engineList.isEmpty()){
//            engineList = engineList1.value.toMutableList()
//        }
//    }

//    fun addEngineToList(typeOfEngine: String, description: String, image: Int) {
//        engineList.add(
//            Engine(
//               engineList.size+1,
//                typeOfEngine,
//                description,
//                image
//            )
//        )
//    }
    //var engineList: List<Engine> = setData.SetEnginesData()
//    fun getOneEngine(id: Int): Engine {
//        for (engine in engineList){
//            if (engine.id == id) {
//                return engine;
//            }
//        }
//        throw NoSuchElementException("Engine with ID $id not found")
//    }

//    fun getEngineList1():List<Engine> {
//        return engineList
//    }
}



