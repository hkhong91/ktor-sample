package com.example.domain.entity

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object MemberTable : Table<Member>("member") {
  val id = int("id").primaryKey().bindTo { it.id }
  val loginId = varchar("login_id").bindTo { it.loginId }
  val name = varchar("name").bindTo { it.name }
  val password = varchar("password").bindTo { it.password }
}

interface Member : Entity<Member> {
  companion object : Entity.Factory<Member>()

  val id: Int
  val loginId: String
  val name: String
  val password: String
}