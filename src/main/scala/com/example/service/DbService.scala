package com.example.service

import com.example.model.User
import com.example.model.Tables.users
import slick.driver.PostgresDriver.api._
import scala.concurrent.Future

trait DbService {
  def retrieveAllUsers: Future[Seq[User]]

  def retrieveUser(id: Long): Future[Option[User]]

  def saveUser(user: User): Future[Unit]

  def deleteUser(id: Long): Future[Int]

  def updateUser(user: User)
}

class DefaultDbService(db: Database) extends DbService {

  override def retrieveAllUsers: Future[Seq[User]] = {
    db.run(users.sortBy(_.id).result)
  }

  override def retrieveUser(id: Long): Future[Option[User]] = {
    db.run(users.filter(_.id === id).result.headOption)
  }

  override def saveUser(user: User): Future[Unit] = {
    db.run(DBIO.seq(users += user))
  }

  override def deleteUser(id: Long): Future[Int] = {
    db.run(users.filter(_.id === id).delete)
  }

  override def updateUser(user: User) = {
    db.run(users.filter(_.id === user.id).update(user))
  }
}
