package com.example.config

import com.typesafe.config.ConfigFactory

/**
  * Created by aliatakan on 19.05.2018.
  */
object AppConfig {

  val config = ConfigFactory.load()

  val serverHost = config.getString("server.host")
  val serverPort = config.getInt("server.port")

}

