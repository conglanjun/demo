package com.example

import com.example.bean.*
import io.micronaut.context.BeanContext
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Test

@MicronautTest
class EngineTest {

    @Test
    fun testEngine() {
        val context = BeanContext.run()
        val bean = context.getBean(Vehicle::class.java)
        println(bean.start())
        println("------------")
        val v2 = context.getBean(Vehicle2::class.java)
        println(v2.start())

        val v3 = context.getBean(Vehicle3::class.java)
        println(v3.start())

        println("------------")
        val v4 = context.getBean(Vehicle4::class.java)
        println(v4.engine.start())
        println(v4.engine)
    }

    @Test
    fun testFactory() {
        val context = BeanContext.run()
        val bean = context.getBean(AggregateEngine::class.java)
        for (e in bean.engines) {
            println(e.cylinders)
            e.start()
        }
    }

    @Test
    fun testEngine1() {
        val context = BeanContext.run()
        val bean = context.getBean(Vehicle5::class.java)
        println(bean.engine)
        println("----------")
        val bean1 = context.getBean(VehicleAny::class.java)
        bean1.start()
    }

}