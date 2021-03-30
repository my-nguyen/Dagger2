package com.florian_walther.dagger2

import dagger.Binds
import dagger.Module
import dagger.Provides

/*
@Module
class PetrolEngineModule {
    @Provides
    fun provideEngine(engine: PetrolEngine): Engine {
        return engine
    }
}*/
// this uses @Binds instead of @Provides, when we want to bind an implementation (PetrolEngine)
// to an interface (Engine) because it's more concise and efficient
@Module
abstract class PetrolEngineModule {
    @Binds
    abstract fun bindEngine(engine: PetrolEngine): Engine
}
