package br.com.narigone.converter.factories

import br.com.narigone.converter.models.User

/**
  * Created by raphael on 6/7/17.
  */
object UserFactory {

  private var userMap = Map[String, User]()

  def buildUserFromDescription(userDescription: String) : User = {
    val mapKey = userDescription.trim().toUpperCase()

    if(this.userMap.contains(mapKey)){
      return userMap(mapKey)
    }

    buildNewUserFromDescription(userDescription)
  }

  private def buildNewUserFromDescription(userDescription: String) : User = {
    val tokenList = userDescription.split("-")
    var userName = ""
    var professionName = ""
    var cityDescription = ""

    for ( i <- 0 until tokenList.length) {
      val token = tokenList(i)
      if( i == 0 ){
        userName = token
      } else if( token.contains( "/" ) ){
        cityDescription = token
      } else {
        professionName = token
      }
    }

    val profession = ProfessionFactory.buildProfessionFromName(professionName)
    val city = CityFactory.buildCityFromDescription(cityDescription)

    val mapSize = userMap.size
    val code = "Suj_" + (mapSize + 1)
    val user = new User(userName, profession, city, code)

    userMap += (userDescription -> user)

    user
  }

  def getUserList : List[User] = {
    var userList : List[User] = List()

    userMap.foreach{
      case(key :String, user:User) => userList = userList :+ user
    }

    userList
  }
}
