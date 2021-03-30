package com.florian_walther.dagger2

import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Inject

// this uses @Binds instead of @Provides
/*@Module
abstract class DieselEngineModule {
    @Binds
    abstract fun bindEngine(engine: DieselEngine): Engine
}*/

// when a constructor takes in an argument that's only known at runtime
/*@Module
class DieselEngineModule(private val horsePower: Int) {
    @Provides
    fun provideEngine(): Engine = DieselEngine(horsePower)
}*/

// added provideHorsePower, which adds it to the dependency graph directly, so Dagger can use it
// whenever horsePower is needed and not just the DieselEngine constructor
// now we can inject DieselEngine constructor
// and we can change the signature of provideEngine as below
@Module
class DieselEngineModule(private val horsePower: Int) {
    @Provides
    fun provideHorsePower() = horsePower

    @Provides
    fun provideEngine(engine: DieselEngine): Engine = engine
}

