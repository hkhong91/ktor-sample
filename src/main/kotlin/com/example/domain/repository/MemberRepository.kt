package com.example.domain.repository

import com.example.domain.schema.Member
import com.example.domain.schema.MemberTable
import com.example.infrastructure.DatabaseConnection
import org.ktorm.dsl.eq
import org.ktorm.dsl.insertAndGenerateKey
import org.ktorm.entity.find
import org.ktorm.entity.sequenceOf

class MemberRepository {
  private val database = DatabaseConnection.database

  fun findByLoginId(loginId: String): Member? {
    return database.sequenceOf(MemberTable)
      .find { it.loginId eq loginId }
  }

  fun save(name: String, loginId: String, password: String): Int {
    return database.insertAndGenerateKey(MemberTable) {
      set(it.name, name)
      set(it.loginId, loginId)
      set(it.password, password)
    } as Int
  }
}