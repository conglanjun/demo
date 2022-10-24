package com.example.learn.micronaut.chapter3

import jakarta.inject.Singleton

interface Engine {
    val cylinders: Int
    fun start(): String
}

@Singleton
class V8Engine : Engine {
    override val cylinders = 8
    override fun start(): String {
        return "Starting V8"
    }
}

@Singleton
class Vehicle(private val engine: Engine) {
    fun start(): String {
        return engine.start()
    }
}