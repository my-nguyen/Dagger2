package com.florian_walther.dagger2

import android.util.Log
import javax.inject.Inject

// by extending an interface, now we can inject a constructor
class PetrolEngine @Inject constructor(): Engine {
    companion object {
        private const val TAG = "Car"
    }

    override fun start() {
        Log.d(TAG, "Petrol engine started")
    }
}