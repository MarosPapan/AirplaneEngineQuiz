package com.example.skuska2.domain.model

import com.example.skuska2.R
import org.mongodb.kbson.ObjectId

object Constants {
    const val USERNAME: String = "user_name"
    private lateinit var username: String
    private lateinit var usernameID: ObjectId

    fun setUsername(usernameP: String){
        username = usernameP
    }

    fun getUsername(): String{
        return username
    }

    fun setUsernameID(usernameP: ObjectId){
        usernameID = usernameP
    }

    fun getUsernameID(): ObjectId{
        return usernameID
    }

////////////////////////////////////////////////////////////////////////////////////////////////////
    fun getTurboPropQuestions(): ArrayList<Question> {
        val questionList = ArrayList<Question>()
        val firstQuest = Question(
            1,
            "What is the primary function of a turbine engine in a turboprop aircraft?",
            "Generate thrust directly by accelerating air through a nozzle.",
            "Convert fuel energy into mechanical energy to drive a propeller.",
            " Cool the engine components to prevent overheating.",
            2,
            R.drawable.game
        )

        questionList.add(firstQuest)

        val secondQuest = Question(
            2,
            "Which component of a turboprop engine compresses incoming air before it enters the combustion chamber?",
            "Turbine",
            "Compressor",
            "Propeller",
            2,
            R.drawable.game
        )

        questionList.add(secondQuest)

        val thirdQuest = Question(
            3,
            "In a turboprop engine, what is the purpose of the reduction gearbox?",
            "To increase the speed of the propeller.",
            "To decrease the speed of the propeller.",
            "To maintain a constant speed of the propeller.",
            2,
            R.drawable.game
        )

        questionList.add(thirdQuest)


        val forthQuest = Question(
            4,
            "What type of fuel is commonly used in turboprop engines?",
            "Jet fuel (kerosene)",
            "Diesel fuel",
            "Avgas (aviation gasoline)",
            1,
            R.drawable.game
        )

        questionList.add(forthQuest)

        val fithQuest = Question(
            5,
            "What is the purpose of the propeller in a turboprop engine?",
            "To generate thrust by accelerating air through a nozzle.",
            "To compress incoming air before combustion.",
            "To convert rotational energy from the engine into thrust.",
            3,
            R.drawable.game
        )

        questionList.add(fithQuest)



        return questionList
    }

    fun getTurboFunQuestions(): ArrayList<Question> {
        val questionList = ArrayList<Question>()
        val firstQuest = Question(
            1,
            "What is the primary function of a turbine engine in a turbofun aircraft?",
            " Convert fuel energy into mechanical energy to drive a fan and provide thrust.",
            "Convert fuel energy into mechanical energy to drive a propeller.",
            " Cool the engine components to prevent overheating.",
            1,
            R.drawable.propeller
        )

        questionList.add(firstQuest)

        val secondQuest = Question(
            2,
            "Which component of a turbofan engine is responsible for accelerating a large amount of air around the engine core?",
            "Turbine",
            "Fan",
            "Propeller",
            2,
            R.drawable.propeller
        )

        questionList.add(secondQuest)

        val thirdQuest = Question(
            3,
            "In a turbofan engine, what is the purpose of the bypass duct?",
            "To bypass the combustion chamber and route some air around the engine core.",
            "To decrease the speed of the propeller.",
            "To increase the speed of the fan airflow.",
            1,
            R.drawable.propeller
        )

        questionList.add(thirdQuest)


        val forthQuest = Question(
            4,
            "What type of fuel is commonly used in turboprop engines?",
            "Jet fuel (kerosene)",
            "Diesel fuel",
            "Avgas (aviation gasoline)",
            1,
            R.drawable.propeller
        )

        questionList.add(forthQuest)

        val fithQuest = Question(
            5,
            "What is the purpose of the Fan in a turboprop engine?",
            "To generate thrust by accelerating air through a nozzle.",
            "To compress incoming air before combustion.",
            "To convert rotational energy from the engine into thrust.",
            1,
            R.drawable.propeller
        )

        questionList.add(fithQuest)



        return questionList
    }

    fun getTurboJetQuestions(): ArrayList<Question> {
        val questionList = ArrayList<Question>()

        val firstQuest = Question(
            1,
            "What is the primary function of a turbine engine in a turbojet aircraft?",
            "Generate thrust directly by accelerating air through a nozzle.",
            "Convert fuel energy into mechanical energy to provide thrust.",
            "Cool the engine components to prevent overheating.",
            2,
            R.drawable.turbine
        )
        questionList.add(firstQuest)

        val secondQuest = Question(
            2,
            "Which component of a turbojet engine compresses incoming air before it enters the combustion chamber?",
            "Turbine",
            "Compressor",
            "Propeller",
            2,
            R.drawable.turbine
        )
        questionList.add(secondQuest)

        val thirdQuest = Question(
            3,
            "In a turbojet engine, what is the purpose of the afterburner?",
            "To increase the speed of the exhaust gases.",
            "To cool down the engine components.",
            "To provide additional thrust by burning extra fuel in the exhaust.",
            3,
            R.drawable.turbine
        )
        questionList.add(thirdQuest)

        val forthQuest = Question(
            4,
            "What type of fuel is commonly used in turbojet engines?",
            "Jet fuel (kerosene)",
            "Diesel fuel",
            "Avgas (aviation gasoline)",
            1,
            R.drawable.turbine
        )
        questionList.add(forthQuest)

        val fithQuest = Question(
            5,
            "What is the purpose of the nozzle in a turbojet engine?",
            "To generate additional thrust by accelerating the exhaust gases.",
            "To compress incoming air before combustion.",
            "To cool down the engine components.",
            1,
            R.drawable.turbine
        )
        questionList.add(fithQuest)

        return questionList
    }

    fun getTurboshaftQuestions(): ArrayList<Question> {
        val questionList = ArrayList<Question>()

        val firstQuest = Question(
            1,
            "What is the primary function of a turbine engine in a turboshaft aircraft?",
            "Generate thrust directly by accelerating air through a nozzle.",
            "Convert fuel energy into mechanical energy to drive a shaft.",
            "Cool the engine components to prevent overheating.",
            2,
            R.drawable.aircraft
        )
        questionList.add(firstQuest)

        val secondQuest = Question(
            2,
            "Which component of a turboshaft engine converts fuel energy into mechanical energy?",
            "Turbine",
            "Compressor",
            "Propeller",
            1,
            R.drawable.aircraft
        )
        questionList.add(secondQuest)

        val thirdQuest = Question(
            3,
            "In a turboshaft engine, what is the purpose of the power turbine?",
            "To drive the compressor.",
            "To drive the propeller.",
            "To extract mechanical energy to drive external systems.",
            3,
            R.drawable.aircraft
        )
        questionList.add(thirdQuest)

        val forthQuest = Question(
            4,
            "What type of aircraft commonly uses turboshaft engines?",
            "Military fighter jets",
            "Commercial airliners",
            "Helicopters",
            3,
            R.drawable.aircraft
        )
        questionList.add(forthQuest)

        val fithQuest = Question(
            5,
            "What is the primary difference between a turboshaft engine and a turboprop engine?",
            "Turboshaft engines drive a shaft to power external systems, while turboprop engines drive a propeller to produce thrust.",
            "Turboshaft engines are smaller in size compared to turboprop engines.",
            "Turboshaft engines are only used in military aircraft, while turboprop engines are used in commercial aircraft.",
            1,
            R.drawable.aircraft
        )
        questionList.add(fithQuest)

        return questionList
    }

}