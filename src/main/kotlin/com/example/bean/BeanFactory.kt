package com.example.bean

import io.micronaut.context.annotation.Factory
import io.micronaut.core.annotation.Order
import jakarta.inject.Singleton

@Factory
class BeanFactory {
    @Singleton
    @Order(1)
    fun engine1(): Engine{
        return V8Engine(8)
    }
    @Singleton
    @Order(10)
    fun engine2(): Engine{
        return V8Engine(9)
    }
    @Singleton
    @Order(5)
    fun engine3(): Engine{
        return V8Engine(10)
    }
}