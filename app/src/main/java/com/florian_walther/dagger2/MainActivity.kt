package com.florian_walther.dagger2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.florian_walther.dagger2.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    // field injection, meant for Framework type that the Android system instantiates, which we have
    // no access to the constructor to do constructor injection, like Activity or Fragment
    @Inject lateinit var car: Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun withoutDagger1() {
        /*val block = Block()
        val cylinders = Cylinders()
        val sparkPlugs = SparkPlugs()
        val engine = Engine(block, cylinders, sparkPlugs)
        val engine = Engine()

        val rims = Rims()
        val tires = Tires()
        val wheels = Wheels(rims, tires)

        val car = Car(engine, wheels)
        car.drive()*/
    }

    private fun withoutDagger2() {
        /*val engine = Engine()
        val rims = Rims()
        val tires = Tires()
        val wheels = Wheels(rims, tires)
        val car = Car(engine, wheels)
        car.drive()*/
    }

    private fun withDagger1() {
        /*val component = DaggerCarComponent.create()
        car = component.getCar()
        car.drive()*/
    }

    private fun withDagger2() {
        // can call DaggerCarComponent.create() only when none of the modules in the component takes
        // arguments in its constructor
        // val component = DaggerCarComponent.create()
        // otherwise we must call DaggerCarComponent.builder() instead and pass in arguments (100
        // as horsePower in this case)
        val component = DaggerCarComponent.builder()
                .dieselEngineModule(DieselEngineModule(100))
                .build()

        component.inject(this)
        car.drive()
    }
}