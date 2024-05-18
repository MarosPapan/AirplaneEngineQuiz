package com.example.skuska2.views

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.skuska2.MyApp
import com.example.skuska2.R
import com.example.skuska2.models.Engine
import io.realm.kotlin.ext.query
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import org.mongodb.kbson.ObjectId

class DetailView: ViewModel() {
    private val realm = MyApp.realm

    var typeOfEngine = mutableStateOf("")
    var descriptionOfEngine = mutableStateOf("")
    var idOfEngine = mutableStateOf(ObjectId)
    var imageOfEngine = mutableStateOf(0)


    fun getEngine1(engineID: ObjectId): Engine?{
        return realm.query<Engine>(query = "_id == $0", engineID).first().find()
    }

    fun getEngineByName(name: String): Engine?{
        var engine: Engine?
        engine = realm.query<Engine>(query = "typeOfEngine == $0", name).first().find()
        println(engine?.typeOfEngine)
        return  engine

    }

//    fun setTypeOfEngine(name: String) {
//        this.typeOfEngine.value = name
//    }
//
//    fun setDescriptionOfEngine(desc: String) {
//        this.descriptionOfEngine.value = desc
//    }
//
//    fun setImage(image: Int){
//        this.imageOfEngine = image
//    }

    fun getImage1(id: ObjectId): Int{
            return getEngine1(id)?.image?.toInt() ?: R.drawable.propeller
    }

    fun getImageByName(name: String): Int{
        return getEngineByName(name)?.image?.toInt() ?: R.drawable.propeller
    }
}