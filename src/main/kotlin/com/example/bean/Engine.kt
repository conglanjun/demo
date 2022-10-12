package com.example.bean

import com.example.annotations.Cylinders
import io.micronaut.context.annotation.Any
import io.micronaut.context.annotation.Bean
import jakarta.inject.Inject
import jakarta.inject.Named
import jakarta.inject.Singleton

interface Engine {

    val cylinders: Int
    fun start(): String

}

interface EngineAny {

    val cylinders: Int
    fun start(): String

}

@Singleton
class V8Engine(override val cylinders: Int) : Engine {

//    override val cylinders = 8

    override fun start(): String {
        return "Starting V8"
    }

}

@Singleton
class V1Engine : Engine {
    override val cylinders: Int = 1

    override fun start(): String {
        return "starting v1"
    }
}

@Singleton
class V2Engine : Engine {
    override val cylinders: Int = 2

    override fun start(): String {
        return "starting v2"
    }
}

@Singleton
class Vehicle(private val engine: Engine = V8Engine(6)) {
    fun start(): String {
        return engine.start()
    }
}

@Singleton
class Vehicle2 @Inject constructor(@param:Named("v1") private val engine: Engine) {
    fun start(): String {
        return engine.start()
    }
}

@Singleton
class AggregateEngine {

    @Inject
    lateinit var engines: List<Engine>

//    override val cylinders = 2
//    override fun start(): String {
//        engines.forEach(Engine::start)
//        return "AggregateEngine Starting VVV"
//    }

}

@Singleton
@Cylinders(value = 10, description = "10-cylinder V10 engine")
class V10Engine : Engine {
    override val cylinders: Int
        get() = 10

    override fun start(): String {
        return "starting V10"
    }
}

@Singleton
@Cylinders(value = 11, description = "11-cylinder V11 engine")
class V11Engine : Engine {
    override val cylinders: Int
        get() = 11

    override fun start(): String {
        return "starting v11"
    }
}

@Singleton
class Vehicle3(@param:Cylinders(10) val engine: Engine) {
    fun start(): String {
        return engine.start()
    }
}

// any
@Singleton
class V1AnyEngine : EngineAny {
    override val cylinders: Int = 1

    override fun start(): String {
        return "starting v1"
    }
}

@Singleton
class V2AnyEngine : EngineAny {
    override val cylinders: Int = 2

    override fun start(): String {
        return "starting v2"
    }
}

// limit
interface EngineLimit {

    val cylinders: Int
    fun start(): String

}

@Singleton
@Bean(typed = [EngineLimit::class])
class V8LimitEngine : EngineLimit {
    override val cylinders: Int = 8
    override fun start(): String {
        return "starting v8 limit engine"
    }
}