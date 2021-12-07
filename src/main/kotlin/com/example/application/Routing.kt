package com.example.application

import com.example.application.request.LoginRequest
import com.example.application.request.MemberRequest
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
      val requestBody = call.receive<MemberRequest>()
      val responseBody = memberService.join(requestBody)
      call.respond(responseBody)
    }

    patch("/members/{memberId}") {
      val memberId = call.parameters["memberId"]?.toInt()
      val requestBody = call.receive<MemberRequest>()
      val responseBody = memberService.update(memberId!!, requestBody)
      call.respond(responseBody)
    }
  }
  routing {
  }
}
