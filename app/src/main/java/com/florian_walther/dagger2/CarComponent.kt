package com.florian_walther.dagger2

import dagger.Component

// here we can easily swap out PetrolEngineModule with DieselEngineModule, thereby testing our app
// with different and potentially fake EngineModule
// but we must not put both PetrolEngineModule and DieselEngineModule, because Dagger wouldn't know
// which engine to use
@Component(modules = [WheelsModule::class, DieselEngineModule::class])
interface CarComponent {
    // must call CarComponent.getCar() to create a Car
    fun getCar(): Car

    // must call inject(this) in MainActivity to create a Car
    fun inject(activity: MainActivity)
}