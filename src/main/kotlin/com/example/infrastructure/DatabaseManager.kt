package com.example.infrastructure

import com.example.domain.entity.Member
import com.example.domain.entity.MemberTable
import org.ktorm.database.Database
import org.ktorm.entity.sequenceOf
import org.ktorm.entity.toList

class DatabaseManager {

  private val ktormDatabase: Database =
    Database.connect("jdbc:mysql://localhost:3306/demo", user = "root", password = "1234")

  fun getMembers(): List<Member> {
    return ktormDatabase.sequenceOf(MemberTable).toList()
  }
}