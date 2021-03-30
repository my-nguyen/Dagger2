package com.florian_walther.dagger2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.florian_walther.dagger2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    private fun withoutDagger() {
        val block = Block()
        val cylinders = Cylinders()
        val sparkPlugs = SparkPlugs()
        // val engine = Engine(block, cylinders, sparkPlugs)
        val engine = Engine()

        val tires = Tires()
        val rims = Rims()
        // val wheels = Wheels(tires, rims)
        val wheels = Wheels()

        val car = Car(engine, wheels)
        car.drive()
    }

    private fun withDagger() {
        val component = DaggerCarComponent.create()
        val car = component.getCar()
        car.drive()
    }
}