package com.example.application

import com.example.application.response.MemberResponse
import com.example.domain.repository.MemberRepository
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.configureRouting() {

  routing {
    val memberRepository = MemberRepository()

    get("/") {
      call.respond(memberRepository.findAll().map { MemberResponse.of(it) })
    }
  }
  routing {
  }
}
