package com.florian_walther.dagger2

import dagger.Binds
import dagger.Module
import dagger.Provides

// this uses @Binds instead of @Provides
@Module
abstract class DieselEngineModule {
    @Binds
    abstract fun bindEngine(engine: DieselEngine): Engine
}
