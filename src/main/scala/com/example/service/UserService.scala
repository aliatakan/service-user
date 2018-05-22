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

  override def retrieveAllUsers: Future[Seq[User]] = {
    dbService.retrieveAllUsers
  }

  override def retrieveUser(id: Long): Future[Option[User]] = {
    dbService.retrieveUser(id)
  }

  override def saveUser(user: User): Future[Unit] = {
    dbService.saveUser(user)
  }

  override def deleteUser(id: Long): Future[Int] = {
    dbService.deleteUser(id)
  }

  override def updateUser(user: User) = {
    dbService.updateUser(user)
  }
}