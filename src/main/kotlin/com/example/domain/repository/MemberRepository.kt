package com.example.domain.repository

import com.example.domain.entity.Member
import com.example.infrastructure.DatabaseManager

class MemberRepository {
  private val database = DatabaseManager()

  fun findAll(): List<Member> {
    return database.getMembers()
  }
}