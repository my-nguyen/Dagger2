package com.florian_walther.dagger2

import android.util.Log
import javax.inject.Inject


// order: (1) constructor injection; (2) field injection; (3) method injection
// if there's constructor injection then Dagger will automatically execute field injection and
// method injection and we don't have to do anything.
// if there's field injection then Dagger will automatically execute method injection and we don't
// have to do anything
// constructor injection
class Car @Inject constructor(val engine: Engine, val wheels: Wheels) {
    companion object {
        const val TAG = "Car"
    }

    // method injection: the only application is when you pass 'this' of an injected class to some
    // method. must make sure the method is executed only after the object has been fully constructed.
    // Dagger will automatically call this method after Car constructor has finished
    // we don't have to invoke this method
    @Inject
    fun enableRemote(remote: Remote) {
        // only call this after 'this' has been constructed
        remote.setListener(this)
    }

    fun drive() {
        engine.start()
        Log.d(TAG, "driving...")
    }
}
