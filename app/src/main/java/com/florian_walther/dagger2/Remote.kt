package com.florian_walther.dagger2

import android.util.Log
import javax.inject.Inject

class Remote @Inject constructor() {
    companion object {
        private const val TAG = "Remote"
    }

    fun setListener(car: Car) {
        Log.d(TAG, "Remote connected")
    }
}