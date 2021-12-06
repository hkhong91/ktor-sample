package com.example.application

import com.example.application.request.JoinRequest
import com.example.application.request.LoginRequest
import com.example.application.service.MemberService
import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.configureRouting() {

  routing {
    val memberService = MemberService()

    post("/members/login") {
      val requestBody = call.receive<LoginRequest>()
      val responseBody = memberService.login(requestBody)
      call.respond(responseBody)
    }

    post("/members/join") {
      val requestBody = call.receive<JoinRequest>()
      val responseBody = memberService.join(requestBody)
      call.respond(responseBody)
    }
  }
  routing {
  }
}
