package com.florian_walther.dagger2

import android.util.Log
import javax.inject.Inject
import javax.inject.Named

// by extending an interface, now we can inject a constructor
// class PetrolEngine @Inject constructor(private val horsePower: Int): Engine {
class PetrolEngine @Inject constructor(@Named("puissance") private val horsePower: Int,
                                       @Named("capacité moteur") private val engineCapacity: Int): Engine {
    companion object {
        private const val TAG = "Car"
    }

    override fun start() {
        Log.d(TAG, "Petrol engine started. Horsepower: $horsePower, Engine capacity: $engineCapacity")
    }
}