package com.example.skuska2.views


import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.skuska2.R
import com.example.skuska2.domain.di.DatabaseModule
import com.example.skuska2.models.Engine
import org.mongodb.kbson.ObjectId

class DetailView: ViewModel() {
    private val realm = DatabaseModule.provideRealm()
    private val repository = DatabaseModule.provideMongoRepository(realm)

    var typeOfEngine = mutableStateOf("")


    fun getEngine1(engineID: ObjectId): Engine?{
        return repository.getEngineById(engineID)
    }

    fun getEngineByName(name: String): Engine?{
        return repository.getEngineByName(name)
    }

    fun getImage1(id: ObjectId): Int{
            return getEngine1(id)?.image?.toInt() ?: R.drawable.propeller
    }

    fun getImageByName(name: String): Int{
        return getEngineByName(name)?.image?.toInt() ?: R.drawable.propeller
    }
}