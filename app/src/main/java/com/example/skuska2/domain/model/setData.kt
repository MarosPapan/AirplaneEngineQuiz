package com.example.skuska2.domain.model

import androidx.compose.ui.graphics.painter.Painter
import com.example.skuska2.R

object setData {

//    fun addNewEngine(id: Int, typeOfEngine: String, description: String, image: Int) {
//        engineList.add(
//            Engine(
//                engineList.size+1,
//                typeOfEngine,
//                description,
//                image
//            )
//        )
//    }

    fun SetEnginesData():MutableList<Engine>{
        var engineList = mutableListOf<Engine>()

        engineList.add(
            Engine(
                1,
                "TurboProp",
                "Principle of Operation: Turboprop engines work by using a gas turbine to drive a propeller. Air is compressed and mixed with fuel in the combustion chamber, where it ignites and produces hot, high-pressure gases. These gases expand through a series of turbine stages, driving a shaft connected to the propeller.\n" +
                        "Propeller Design: The propeller in a turboprop engine is typically larger and slower-turning than those on piston-engine aircraft. It converts the rotational energy from the engine into thrust, propelling the aircraft forward.\n" +
                        "Efficiency: Turboprop engines are highly efficient at lower speeds and altitudes compared to turbofan engines. They are commonly used in smaller aircraft and regional airliners for short to medium-haul flights.\n" +
                        "Fuel Efficiency: Turboprops are generally more fuel-efficient than pure jet engines, particularly at lower speeds and altitudes. This makes them suitable for shorter flights and operations into smaller airports where jet engines might be less economical.\n" +
                        "Applications: Turboprop engines are commonly found in various aircraft types, including commuter airliners, cargo planes, military transport aircraft, and general aviation aircraft. They are favored for their versatility, reliability, and fuel efficiency.\n" +
                        "Maintenance: Turboprop engines require regular maintenance to ensure optimal performance and safety. Maintenance schedules typically include checks on engine components, propeller systems, and other related systems.\n" +
                        "Noise Level: Compared to pure jet engines, turboprops tend to produce less noise, making them suitable for operations in noise-sensitive areas or for flights over populated areas.",
                R.drawable.game
            )
        )

        engineList.add(
            Engine(
                2,
                "TurboFan",
                "Turbofan engines are a type of gas turbine engine that incorporates a large fan at the front, which generates additional thrust by bypassing air around the engine core. They are widely used in commercial airliners, business jets, and military aircraft.",
                R.drawable.propeller
            )
        )

        engineList.add(
            Engine(
                3,
                "TurboJet",
                "Turbojet engines are a basic type of gas turbine engine that produces thrust by expelling exhaust gases at high speed through a nozzle. They were historically common in early jet aircraft but are now mostly used in military applications, such as fighter jets.",
                R.drawable.turbine
            )
        )

        engineList.add(
            Engine(
                4,
                "TurboShaft",
                "Turboshaft engines are similar to turboprop engines but are optimized to produce shaft power rather than thrust. They are commonly used in helicopters, tiltrotor aircraft, and some small fixed-wing aircraft.",
                R.drawable.aircraft
            )
        )
        return engineList
    }

//    fun getEngineData(): List<Engine>{
//        return engineList;
//    }

    fun getOneEngine(id: Int): Engine {
        for (engine in SetEnginesData()){
            if (engine.id == id) {
                return engine;
            }
        }
        throw NoSuchElementException("Engine with ID $id not found")
    }

    fun emptyEnginesData() {

    }

}