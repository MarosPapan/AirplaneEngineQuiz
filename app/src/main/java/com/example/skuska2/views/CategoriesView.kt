package com.example.skuska2.views

import androidx.lifecycle.ViewModel
import com.example.skuska2.domain.model.Constants
import com.example.skuska2.domain.model.Engine
import com.example.skuska2.domain.model.Question
import com.example.skuska2.domain.model.setData
import kotlin.reflect.KProperty

class CategoriesView: ViewModel() {
    //private var engineList: List<Engine> = setData.SetEnginesData()
    private var engineList = mutableListOf<Engine>()
    fun initializeEngineList() {
        if(engineList.isEmpty()){
            engineList = setData.SetEnginesData()
        }
    }

    fun addEngineToList(typeOfEngine: String, description: String, image: Int) {
        engineList.add(
            Engine(
               engineList.size+1,
                typeOfEngine,
                description,
                image
            )
        )
    }
    //var engineList: List<Engine> = setData.SetEnginesData()
    fun getOneEngine(id: Int): Engine {
        for (engine in engineList){
            if (engine.id == id) {
                return engine;
            }
        }
        throw NoSuchElementException("Engine with ID $id not found")
    }

    fun getEngineList1():List<Engine> {
        return engineList
    }
}



