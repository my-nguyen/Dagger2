package com.florian_walther.dagger2

import dagger.Component

@Component(modules = [WheelsModule::class])
interface CarComponent {
    // must call CarComponent.getCar() to create a Car
    fun getCar(): Car

    // must call inject(this) in MainActivity to create a Car
    fun inject(activity: MainActivity)
}