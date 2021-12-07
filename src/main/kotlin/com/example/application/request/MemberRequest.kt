package com.example.application.request

data class MemberRequest(
  val loginId: String,
  val name: String,
  val password: String,
)