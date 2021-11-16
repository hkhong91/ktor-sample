package com.example

import com.example.application.configureRouting
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
  embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
    configureRouting()
    install(ContentNegotiation) {
      gson {
        setPrettyPrinting()
        disableHtmlEscaping()
      }
    }
  }.start(wait = true)
}
