package com.florian_walther.dagger2

import android.util.Log
import javax.inject.Inject

/*class DieselEngine @Inject constructor(): Engine {
    companion object {
        private const val TAG = "Car"
    }

    override fun start() {
        Log.d(TAG, "Diesel engine started")
    }
}*/
// when a constructor takes in an argument that's only known at runtime
class DieselEngine(private val horsePower: Int): Engine {
    companion object {
        private const val TAG = "Car"
    }

    override fun start() {
        Log.d(TAG, "Diesel engine started. Horsepower: $horsePower")
    }
}
