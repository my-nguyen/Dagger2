package com.florian_walther.dagger2

import dagger.Binds
import dagger.Module
import dagger.Provides

// this uses @Binds instead of @Provides
/*@Module
abstract class DieselEngineModule {
    @Binds
    abstract fun bindEngine(engine: DieselEngine): Engine
}*/
// when a constructor takes in an argument that's only known at runtime
@Module
class DieselEngineModule(private val horsePower: Int) {
    @Provides
    fun provideEngine(): Engine = DieselEngine(horsePower)
}
