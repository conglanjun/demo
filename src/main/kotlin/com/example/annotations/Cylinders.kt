package com.example.annotations

import io.micronaut.context.annotation.NonBinding
import jakarta.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Cylinders(
    val value: Int,
    @get:NonBinding
    val description: String = ""
)
