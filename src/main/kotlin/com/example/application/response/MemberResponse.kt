package com.example.application.response

data class MemberResponse(
  val id: Int,
  val loginId: String,
  val name: String,
  val password: String,
)