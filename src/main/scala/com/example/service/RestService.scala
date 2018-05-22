package com.example.service

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.server.Directives._
import com.example.model.{JsonSupport, User}
import scala.concurrent.Future

class RestService(userService: UserService) extends SprayJsonSupport with JsonSupport{

  val routes =
    get {
      path("status") {
        complete("OK")
      } ~ path("users" / LongNumber) { id =>
        rejectEmptyResponse {
          complete { userService.retrieveUser(id) }
        }
      } ~ path("users"){
       rejectEmptyResponse {
          complete { userService.retrieveAllUsers }
        }
      }
    } ~ post {
      path("users") {
        entity(as[User]) { user =>
          val savedUser: Future[Unit] = userService.saveUser(user)
          onSuccess(savedUser) {
            complete("user has been saved")
          }
        }
      }
    } ~ delete {
      path("users" / LongNumber) { id =>
        rejectEmptyResponse {
          val deletedUser: Future[Int] = userService.deleteUser(id)
          complete("user has been deleted")
        }
      }
    } ~ put {
      entity(as[User]) { user =>
        userService.updateUser(user)
        complete("user has been updated")
      }
    }
}