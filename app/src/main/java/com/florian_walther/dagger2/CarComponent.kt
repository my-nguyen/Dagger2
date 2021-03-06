package com.florian_walther.dagger2

import dagger.BindsInstance
import dagger.Component
import javax.inject.Named

// here we can easily swap out PetrolEngineModule with DieselEngineModule, thereby testing our app
// with different and potentially fake EngineModule
// but we must not put both PetrolEngineModule and DieselEngineModule, because Dagger wouldn't know
// which engine to use
@Component(modules = [WheelsModule::class, PetrolEngineModule::class])
interface CarComponent {
    // must call CarComponent.getCar() to create a Car
    fun getCar(): Car

    // must call inject(this) in MainActivity to create a Car
    fun inject(activity: MainActivity)

    @Component.Builder
    interface Builder {
        // with @BindsInstance we can get variable into dependency graph at runtime, which has the
        // same effect as passing a value to a module at runtime and providing it with @Provides
        @BindsInstance
        fun horsePower(@Named("puissance") horsePower: Int): Builder

        @BindsInstance
        fun engineCapacity(@Named("capacité moteur") engineCapacity: Int): Builder

        // just by declaring this method, Dagger will implement this
        fun build(): CarComponent
    }
}