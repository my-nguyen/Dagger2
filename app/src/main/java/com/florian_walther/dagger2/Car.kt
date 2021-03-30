package com.florian_walther.dagger2

import android.util.Log
import javax.inject.Inject

class Block()
class Cylinders()
class SparkPlugs()
// data class Engine @Inject constructor(val block: Block, val cylinders: Cylinders, val sparkPlugs: SparkPlugs)
class Engine @Inject constructor()

class Tires()
class Rims()
// data class Wheels @Inject constructor(val tires: Tires, val rims: Rims)
class Wheels @Inject constructor()

class Car @Inject constructor(val engine: Engine, val wheels: Wheels) {
    companion object {
        const val TAG = "Car"
    }

    fun drive() {
        Log.d(TAG, "driving...")
    }
}
