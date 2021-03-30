package com.florian_walther.dagger2

import dagger.Component

@Component
interface CarComponent {
    fun getCar(): Car
}