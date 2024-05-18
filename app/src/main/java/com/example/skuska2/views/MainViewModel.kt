package com.example.skuska2.views

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.skuska2.R
import com.example.skuska2.domain.di.DatabaseModule
import com.example.skuska2.models.Engine
import com.example.skuska2.models.Question
import com.example.skuska2.models.Quiz
import io.realm.kotlin.UpdatePolicy
import io.realm.kotlin.ext.realmListOf
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    private val realm = DatabaseModule.provideRealm()

//    init {
//        createSampleEntries()
//    }

     fun createSampleEntries() {
        viewModelScope.launch {
            realm.write {
                val engine1 = Engine().apply {
                    typeOfEngine = "TurboProp"
                    description = "Principle of Operation: Turboprop engines work by using a gas turbine to drive a propeller. Air is compressed and mixed with fuel in the combustion chamber, where it ignites and produces hot, high-pressure gases. These gases expand through a series of turbine stages, driving a shaft connected to the propeller.\n" +
                            "Propeller Design: The propeller in a turboprop engine is typically larger and slower-turning than those on piston-engine aircraft. It converts the rotational energy from the engine into thrust, propelling the aircraft forward.\n" +
                            "Efficiency: Turboprop engines are highly efficient at lower speeds and altitudes compared to turbofan engines. They are commonly used in smaller aircraft and regional airliners for short to medium-haul flights.\n" +
                            "Fuel Efficiency: Turboprops are generally more fuel-efficient than pure jet engines, particularly at lower speeds and altitudes. This makes them suitable for shorter flights and operations into smaller airports where jet engines might be less economical.\n" +
                            "Applications: Turboprop engines are commonly found in various aircraft types, including commuter airliners, cargo planes, military transport aircraft, and general aviation aircraft. They are favored for their versatility, reliability, and fuel efficiency.\n" +
                            "Maintenance: Turboprop engines require regular maintenance to ensure optimal performance and safety. Maintenance schedules typically include checks on engine components, propeller systems, and other related systems.\n" +
                            "Noise Level: Compared to pure jet engines, turboprops tend to produce less noise, making them suitable for operations in noise-sensitive areas or for flights over populated areas."
                    image = R.drawable.game
                }
                val engine2 = Engine().apply {
                    typeOfEngine = "TurboFan"
                    description = "Turbofan engines are a type of gas turbine engine that incorporates a large fan at the front, which generates additional thrust by bypassing air around the engine core. They are widely used in commercial airliners, business jets, and military aircraft."
                    image = R.drawable.propeller
                }
                val engine3 = Engine().apply {
                    typeOfEngine = "TurboJet"
                    description = "Turbojet engines are a basic type of gas turbine engine that produces thrust by expelling exhaust gases at high speed through a nozzle. They were historically common in early jet aircraft but are now mostly used in military applications, such as fighter jets."
                    image = R.drawable.turbine
                }
                val engine4 = Engine().apply {
                    typeOfEngine = "TurboShaft"
                    description = "Turboshaft engines are similar to turboprop engines but are optimized to produce shaft power rather than thrust. They are commonly used in helicopters, tiltrotor aircraft, and some small fixed-wing aircraft."
                    image = R.drawable.aircraft
                }

                val questionProp1 = Question().apply {
                    question = "What is the primary function of a turbine engine in a turboprop aircraft?"
                    optionOne = "Generate thrust directly by accelerating air through a nozzle."
                    optionTwo = "Convert fuel energy into mechanical energy to drive a propeller."
                    optionThree = " Cool the engine components to prevent overheating."
                    correctAnswer = 2
                    image = R.drawable.game
                    engine = engine1
                }

                val questionProp2 = Question().apply {
                    question = "Which component of a turboprop engine compresses incoming air before it enters the combustion chamber?"
                    optionOne = "Turbine"
                    optionTwo = "Compressor"
                    optionThree = "Propeller"
                    correctAnswer = 2
                    image = R.drawable.game
                    engine = engine1
                }

                val questionProp3 = Question().apply {
                    question = "In a turboprop engine, what is the purpose of the reduction gearbox?"
                    optionOne = "To increase the speed of the propeller."
                    optionTwo = "To decrease the speed of the propeller."
                    optionThree = "To maintain a constant speed of the propeller."
                    correctAnswer = 2
                    image = R.drawable.game
                    engine = engine1
                }

                val questionProp4 = Question().apply {
                    question = "What type of fuel is commonly used in turboprop engines?"
                    optionOne = "Jet fuel (kerosene)"
                    optionTwo = "Diesel fuel"
                    optionThree = "Avgas (aviation gasoline)"
                    correctAnswer = 1
                    image = R.drawable.game
                    engine = engine1
                }

                val questionProp5 = Question().apply {
                    question = "What is the purpose of the propeller in a turboprop engine?"
                    optionOne = "To generate thrust by accelerating air through a nozzle."
                    optionTwo = "To compress incoming air before combustion."
                    optionThree = "To convert rotational energy from the engine into thrust."
                    correctAnswer = 3
                    image = R.drawable.game
                    engine = engine1
                }

                val questionFan1 = Question().apply {
                    question = "What is the primary function of a turbine engine in a turbofun aircraft?"
                    optionOne = "Convert fuel energy into mechanical energy to drive a fan and provide thrust."
                    optionTwo = "Convert fuel energy into mechanical energy to drive a propeller."
                    optionThree = "Cool the engine components to prevent overheating."
                    correctAnswer = 1
                    image = R.drawable.propeller
                    engine = engine2
                }

                val questionFan2 = Question().apply {
                    question = "Which component of a turbofan engine is responsible for accelerating a large amount of air around the engine core?"
                    optionOne = "Turbine"
                    optionTwo = "Fan"
                    optionThree = "Propeller"
                    correctAnswer = 2
                    image = R.drawable.propeller
                    engine = engine2
                }

                val questionFan3 = Question().apply {
                    question = "In a turbofan engine, what is the purpose of the bypass duct?"
                    optionOne = "To bypass the combustion chamber and route some air around the engine core."
                    optionTwo = "To decrease the speed of the propeller."
                    optionThree = "To increase the speed of the fan airflow."
                    correctAnswer = 1
                    image = R.drawable.propeller
                    engine = engine2
                }

                val questionFan4 = Question().apply {
                    question = "What is the purpose of the Fan in a turboprop engine?"
                    optionOne = "To generate thrust by accelerating air through a nozzle."
                    optionTwo = "To compress incoming air before combustion."
                    optionThree = "To convert rotational energy from the engine into thrust."
                    correctAnswer = 1
                    image = R.drawable.propeller
                    engine = engine2
                }

                val questionFan5 = Question().apply {
                    question = "What type of fuel is commonly used in turboprop engines?"
                    optionOne = "Jet fuel (kerosene)"
                    optionTwo = "Diesel fuel"
                    optionThree = "Avgas (aviation gasoline)"
                    correctAnswer = 1
                    image = R.drawable.propeller
                    engine = engine2
                }

                val questionJet1 = Question().apply {
                    question = "What is the primary function of a turbine engine in a turbojet aircraft?"
                    optionOne = "Generate thrust directly by accelerating air through a nozzle."
                    optionTwo = "Convert fuel energy into mechanical energy to provide thrust."
                    optionThree = "Cool the engine components to prevent overheating."
                    correctAnswer = 2
                    image = R.drawable.turbine
                    engine = engine3
                }

                val questionJet2 = Question().apply {
                    question = "Which component of a turbojet engine compresses incoming air before it enters the combustion chamber?"
                    optionOne = "Turbine"
                    optionTwo = "Compressor"
                    optionThree = "Propeller"
                    correctAnswer = 2
                    image = R.drawable.turbine
                    engine = engine3
                }

                val questionJet3 = Question().apply {
                    question = "In a turbojet engine, what is the purpose of the afterburner?"
                    optionOne = "To increase the speed of the exhaust gases."
                    optionTwo = "To cool down the engine components."
                    optionThree = "To provide additional thrust by burning extra fuel in the exhaust."
                    correctAnswer = 3
                    image = R.drawable.turbine
                    engine = engine3
                }

                val questionJet4 = Question().apply {
                    question = "What type of fuel is commonly used in turbojet engines?"
                    optionOne = "Jet fuel (kerosene)"
                    optionTwo = "Diesel fuel"
                    optionThree = "Avgas (aviation gasoline)"
                    correctAnswer = 1
                    image = R.drawable.aircraft
                    engine = engine3
                }

                val questionJet5 = Question().apply {
                    question = "What is the purpose of the nozzle in a turbojet engine?"
                    optionOne = "To generate additional thrust by accelerating the exhaust gases."
                    optionTwo = "To compress incoming air before combustion."
                    optionThree = "To cool down the engine components."
                    correctAnswer = 1
                    image = R.drawable.aircraft
                    engine = engine3
                }

                val questionShaft1 = Question().apply {
                    question = "What is the primary function of a turbine engine in a turboshaft aircraft?"
                    optionOne = "Generate thrust directly by accelerating air through a nozzle."
                    optionTwo = "Convert fuel energy into mechanical energy to drive a shaft."
                    optionThree = "Cool the engine components to prevent overheating."
                    correctAnswer = 2
                    image = R.drawable.aircraft
                    engine = engine4
                }

                val questionShaft2 = Question().apply {
                    question = "Which component of a turboshaft engine converts fuel energy into mechanical energy?"
                    optionOne = "Turbine"
                    optionTwo = "Compressor"
                    optionThree = "Propeller"
                    correctAnswer = 1
                    image = R.drawable.aircraft
                    engine = engine4
                }

                val questionShaft3 = Question().apply {
                    question = "In a turboshaft engine, what is the purpose of the power turbine?"
                    optionOne = "To drive the compressor."
                    optionTwo = "To drive the propeller."
                    optionThree = "To extract mechanical energy to drive external systems."
                    correctAnswer = 3
                    image = R.drawable.aircraft
                    engine = engine4
                }

                val questionShaft4 = Question().apply {
                    question = "What type of aircraft commonly uses turboshaft engines?"
                    optionOne = "Military fighter jets"
                    optionTwo = "Commercial airliners"
                    optionThree = "Helicopters"
                    correctAnswer = 3
                    image = R.drawable.aircraft
                    engine = engine4
                }

                val questionShaft5 = Question().apply {
                    question = "What is the primary difference between a turboshaft engine and a turboprop engine?"
                    optionOne = "Turboshaft engines drive a shaft to power external systems, while turboprop engines drive a propeller to produce thrust."
                    optionTwo = "Turboshaft engines are smaller in size compared to turboprop engines."
                    optionThree = "Turboshaft engines are only used in military aircraft, while turboprop engines are used in commercial aircraft."
                    correctAnswer = 1
                    image = R.drawable.aircraft
                    engine = engine4
                }

                val quizProp = Quiz().apply {
                    questions = realmListOf(questionProp1, questionProp2, questionProp3, questionProp4, questionProp5)
                    quizOfEngine = engine1
                }

                val quizFan = Quiz().apply {
                    questions = realmListOf(questionFan1, questionFan2, questionFan3, questionFan4, questionFan5)
                    quizOfEngine = engine2
                }

                val quizJet = Quiz().apply {
                    questions = realmListOf(questionJet1, questionJet2, questionJet3, questionJet4, questionJet5)
                    quizOfEngine = engine3
                }

                val quizShaft = Quiz().apply {
                    questions = realmListOf(questionShaft1, questionShaft2, questionShaft3, questionShaft4, questionShaft5)
                    quizOfEngine = engine4
                }

                copyToRealm(engine1, updatePolicy = UpdatePolicy.ALL)
                copyToRealm(engine2, updatePolicy = UpdatePolicy.ALL)
                copyToRealm(engine3, updatePolicy = UpdatePolicy.ALL)
                copyToRealm(engine4, updatePolicy = UpdatePolicy.ALL)

                copyToRealm(questionProp1, updatePolicy = UpdatePolicy.ALL)
                copyToRealm(questionProp2, updatePolicy = UpdatePolicy.ALL)
                copyToRealm(questionProp3, updatePolicy = UpdatePolicy.ALL)
                copyToRealm(questionProp4, updatePolicy = UpdatePolicy.ALL)
                copyToRealm(questionProp5, updatePolicy = UpdatePolicy.ALL)

                copyToRealm(questionFan1, updatePolicy = UpdatePolicy.ALL)
                copyToRealm(questionFan2, updatePolicy = UpdatePolicy.ALL)
                copyToRealm(questionFan3, updatePolicy = UpdatePolicy.ALL)
                copyToRealm(questionFan4, updatePolicy = UpdatePolicy.ALL)
                copyToRealm(questionFan5, updatePolicy = UpdatePolicy.ALL)

                copyToRealm(questionJet1, updatePolicy = UpdatePolicy.ALL)
                copyToRealm(questionJet2, updatePolicy = UpdatePolicy.ALL)
                copyToRealm(questionJet3, updatePolicy = UpdatePolicy.ALL)
                copyToRealm(questionJet4, updatePolicy = UpdatePolicy.ALL)
                copyToRealm(questionJet5, updatePolicy = UpdatePolicy.ALL)

                copyToRealm(questionShaft1, updatePolicy = UpdatePolicy.ALL)
                copyToRealm(questionShaft2, updatePolicy = UpdatePolicy.ALL)
                copyToRealm(questionShaft3, updatePolicy = UpdatePolicy.ALL)
                copyToRealm(questionShaft4, updatePolicy = UpdatePolicy.ALL)
                copyToRealm(questionShaft5, updatePolicy = UpdatePolicy.ALL)

                copyToRealm(quizProp, updatePolicy = UpdatePolicy.ALL)
                copyToRealm(quizFan, updatePolicy = UpdatePolicy.ALL)
                copyToRealm(quizJet, updatePolicy = UpdatePolicy.ALL)
                copyToRealm(quizShaft, updatePolicy = UpdatePolicy.ALL)

            }
        }
    }
}