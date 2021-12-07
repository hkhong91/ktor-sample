package com.example.application.service

import com.example.application.request.LoginRequest
import com.example.application.request.MemberRequest
import com.example.application.response.MemberResponse
import com.example.domain.schema.MemberTable
import com.example.infrastructure.DatabaseConnection
import io.ktor.features.*
import org.ktorm.dsl.eq
import org.ktorm.dsl.insertAndGenerateKey
import org.ktorm.dsl.update
import org.ktorm.entity.find
import org.ktorm.entity.sequenceOf

class MemberService {

  private val database = DatabaseConnection.database

  fun login(request: LoginRequest): MemberResponse {
    val member = database.sequenceOf(MemberTable)
      .find { it.loginId eq request.loginId } ?: throw NotFoundException()
    if (member.password != request.password) {
      throw NotFoundException()
    }
    return MemberResponse(
      id = member.id!!,
      loginId = member.loginId,
      name = member.name,
      password = member.password
    )
  }

  fun join(request: MemberRequest): MemberResponse {
    val memberId = database.insertAndGenerateKey(MemberTable) {
      set(it.name, request.name)
      set(it.loginId, request.loginId)
      set(it.password, request.password)
    } as Int

    return MemberResponse(
      id = memberId,
      loginId = request.loginId,
      name = request.name,
      password = request.password
    )
  }

  fun update(memberId: Int, request: MemberRequest): MemberResponse {
    val result = database.update(MemberTable) {
      set(it.name, request.name)
      set(it.loginId, request.loginId)
      set(it.password, request.password)
      where {
        it.id eq memberId
      }
    }

    if (result > 0) {
      return MemberResponse(
        id = memberId,
        loginId = request.loginId,
        name = request.name,
        password = request.password
      )
    } else {
      throw NotFoundException()
    }
  }
}