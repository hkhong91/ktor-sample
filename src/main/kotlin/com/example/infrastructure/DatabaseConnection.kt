package com.example.infrastructure

import org.ktorm.database.Database

object DatabaseConnection {

  val database: Database =
    Database.connect(
      url = "jdbc:mysql://localhost:3306/demo",
      driver = "com.mysql.cj.jdbc.Driver",
      user = "root",
      password = "1234",
    )
}