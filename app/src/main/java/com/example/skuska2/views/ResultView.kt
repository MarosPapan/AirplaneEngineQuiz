package com.example.skuska2.views

import androidx.lifecycle.ViewModel
import com.example.skuska2.MyApp
import com.example.skuska2.R
import com.example.skuska2.models.Engine
import io.realm.kotlin.ext.query

class ResultView: ViewModel() {
    private val realm = MyApp.realm

    fun getEngineByName(name: String): Engine?{
        var engine: Engine?
        engine = realm.query<Engine>(query = "typeOfEngine CONTAINS[c] $0", name).first().find()
        println(engine?.typeOfEngine)
        return  engine
    }

    fun getImageByName(name: String): Int{
        return getEngineByName(name)?.image?.toInt() ?: R.drawable.propeller
    }
}