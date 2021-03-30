package com.florian_walther.dagger2

import android.util.Log

// we don't own this class so we can't annotate it with @Inject
class Tires() {
    companion object {
        private const val TAG = "Car"
    }

    fun inflate() {
        Log.d(TAG, "Tire inflated")
    }
}

class Rims()

data class Wheels(val rims: Rims, val tires: Tires)

// class Wheels @Inject constructor()
