package br.com.narigone.converter.factories

import br.com.narigone.converter.models.User

/**
  * Created by raphael on 6/7/17.
  */
object UserFactory {
  private var userMap = Map[String, User]()

  def buildUserFromName(userName: String) : User = {
    val mapKey = userName.trim().toUpperCase()

    if(this.userMap.contains(mapKey)){
      return userMap(mapKey)
    }

    buildNewUserFromName(userName, mapKey)
  }

  private def buildNewUserFromName(userName: String, mapKey: String) = {
    val mapSize = userMap.size
    val code = "Suj_" + (mapSize + 1)
    val user = new User(userName, code)
    userMap += (mapKey -> user)
    user
  }

  def getUserList() : List[User] = {
    var userList : List[User] = List()

    userMap.foreach{
      case(key :String, user:User) => userList = userList :+ user
    }

    userList
  }
}
