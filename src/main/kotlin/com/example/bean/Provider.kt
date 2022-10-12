package com.example.bean

import io.micronaut.context.BeanProvider
import io.micronaut.context.annotation.Any
import io.micronaut.context.annotation.Primary
import io.micronaut.context.annotation.Secondary
import jakarta.inject.Inject
import jakarta.inject.Singleton

interface CylinderProvider {
    val cylinders: Int
}

interface Engine1<T : CylinderProvider> {
    val cylinders: Int
        get() = cylinderProvider.cylinders

    fun start(): String {
        return "$ Starting ${cylinderProvider.javaClass.simpleName}"
    }

    val cylinderProvider: T
}

class V6 : CylinderProvider {
    override val cylinders: Int = 6
}

@Singleton
class V6Engine1 : Engine1<V6> {
    override val cylinderProvider: V6
        get() = V6()
}

class V8 : CylinderProvider {
    override val cylinders: Int = 8
}

@Singleton
class V8Engine1 : Engine1<V8> {
    override val cylinderProvider: V8
        get() = V8()
}

@Singleton
class Vehicle4(val engine: Engine1<V6>)

interface ColorPicker {
    fun color(): String
}

//@Primary
@Secondary
@Singleton
class Green : ColorPicker {
    override fun color(): String {
        return "green"
    }
}

@Singleton
class Blue : ColorPicker {
    override fun color(): String {
        return "blue"
    }
}

// any
class Vehicle5 {
    @Inject
    @field:Any
    lateinit var engine: EngineAny
}

@Singleton
class VehicleAny(@param:Any val engineProvider: BeanProvider<Vehicle5>) {
    fun start() {
        engineProvider.ifPresent { println(it.engine.start()) }
    }

    fun startAll() {
        if (engineProvider.isPresent) {
            engineProvider.forEach { println(it.engine.start()) }
        }
    }
}