package com.florian_walther.dagger2

import dagger.Module
import dagger.Provides

// collection of methods to provide objects whose constructors we have no access to
@Module
class WheelsModule {
    @Provides
    fun provideRims() = Rims()

    @Provides
    fun provideTires(): Tires {
        val tires = Tires()
        tires.inflate()
        return tires
    }

    @Provides
    fun provideWheels(rims: Rims, tires: Tires) = Wheels(rims, tires)
}