package com.example.service

import com.example.model.User
import scala.concurrent.{Future}

trait UserService {
  def retrieveAllUsers: Future[Seq[User]]

  def retrieveUser(id: Long): Future[Option[User]]

  def saveUser(user: User): Future[Unit]

  def deleteUser(id: Long): Future[Int]

  def updateUser(user: User)
}

class DefaultUserService(dbService: DbService) extends UserService{

  def retrieveAllUsers: Future[Seq[User]] = {
    dbService.retrieveAllUsers
  }

  def retrieveUser(id: Long): Future[Option[User]] = {
    dbService.retrieveUser(id)
  }

  def saveUser(user: User): Future[Unit] = {
    dbService.saveUser(user)
  }

  def deleteUser(id: Long): Future[Int] = {
    dbService.deleteUser(id)
  }

  def updateUser(user: User) = {
    dbService.updateUser(user)
  }
}