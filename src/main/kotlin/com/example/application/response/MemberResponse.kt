package com.example.application.response

import com.example.domain.entity.Member

data class MemberResponse(
  val id: Int,
  val loginId: String,
  val name: String,
  val password: String,
) {
  companion object {
    fun of(member: Member): MemberResponse {
      return MemberResponse(
        id = member.id,
        loginId = member.loginId,
        name = member.name,
        password = member.password
      )
    }
  }
}