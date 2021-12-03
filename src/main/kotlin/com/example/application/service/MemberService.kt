package com.example.application.service

import com.example.application.request.LoginRequest
import com.example.application.response.MemberResponse
import com.example.domain.repository.MemberRepository
import io.ktor.features.*

class MemberService {

  private val memberRepository = MemberRepository()

  fun login(request: LoginRequest): MemberResponse {
    val member = memberRepository.findByLoginId(request.loginId) ?: throw NotFoundException()
    if (!member.check(request.password)) {
      throw NotFoundException()
    }
    return MemberResponse.of(member)
  }
}