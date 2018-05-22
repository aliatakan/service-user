package com.example.model

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import slick.driver.PostgresDriver.api._
import spray.json.DefaultJsonProtocol

final case class User(id: Option[Long], name: String, surname: String, fullName: String)

trait JsonSupport extends SprayJsonSupport with DefaultJsonProtocol {
  implicit val userFormat = jsonFormat4(User)
}

object Tables {
  class Users(tag: Tag ) extends Table[User](tag, "platformusers") {
    def id = column[Option[Long]]("id", O.PrimaryKey, O.AutoInc)

    def name = column[String]("name")

    def surname = column[String]("surname")

    def fullName = column[String]("fullname")

    def * = (id, name, surname, fullName) <> (User.tupled, User.unapply)
  }

  val users = TableQuery[Users]

}
