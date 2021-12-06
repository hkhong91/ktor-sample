package com.example.application.service

import com.example.application.request.JoinRequest
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
    return MemberResponse(
      id = member.id!!,
      loginId = member.loginId,
      name = member.name,
      password = member.password
    )
  }

  fun join(request: JoinRequest): MemberResponse {
    val memberId = memberRepository.save(
      name = request.name,
      loginId = request.loginId,
      password = request.password,
    )
    return MemberResponse(
      id = memberId,
      loginId = request.loginId,
      name = request.name,
      password = request.password
    )
  }
}