package com.example

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.example.service.{DefaultDbService, DefaultUserService, RestService}
import com.example.config.AppConfig._
import slick.driver.PostgresDriver.api._


object Boot extends App {

  implicit val actorSystem = ActorSystem("system")
  implicit val actorMaterializer = ActorMaterializer()

  val restService = new RestService(new DefaultUserService(new DefaultDbService(Database.forConfig("db"))));

  Http().bindAndHandle(restService.routes, serverHost, serverPort)
}
