package com.example.infrastructure

import org.ktorm.database.Database

class DatabaseManager {

  init {
    Database.connect("jdbc:mysql://localhost:3306/demo", user = "root", password = "1234")
  }
}