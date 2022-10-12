package com.example

import com.example.client.HelloClient
import com.example.client.TestClient
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import reactor.core.publisher.Mono

@MicronautTest
class ClientTest {

    @Inject
    lateinit var client: HelloClient

    @Inject
    lateinit var client1: TestClient

    @Test
    fun testHelloWorldResponse() {
        assertEquals("hello world!!!", Mono.from(client.hello()).block())
        println(Mono.from(client.hello()).block())
        println("hello11111")

        println("---------")
        println(Mono.from(client1.hello1()).block())
    }

}