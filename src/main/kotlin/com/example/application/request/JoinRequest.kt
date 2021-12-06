package com.example.application.request

data class JoinRequest(
  val loginId: String,
  val name: String,
  val password: String,
)