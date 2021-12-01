package com.example.domain.repository

import com.example.domain.entity.Member
import com.example.domain.entity.MemberTable
import com.example.infrastructure.DatabaseConnection
import org.ktorm.entity.sequenceOf
import org.ktorm.entity.toList

class MemberRepository {
  private val database = DatabaseConnection.database

  fun findAll(): List<Member> {
    return database.sequenceOf(MemberTable).toList()
  }
}