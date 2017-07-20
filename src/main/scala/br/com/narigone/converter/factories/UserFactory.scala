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
        userName = token.trim
      } else if( token.contains( "/" ) ){
        cityDescription = token
        val tokens = cityDescription.split("/")
        try {
          val state = tokens(tokens.length - 1)
          if (tokens.length > 1 && state.contains(" ")) {
            professionName = state.substring(state.indexOf(" ")).trim
            if(!professionName.isEmpty) {
              cityDescription = cityDescription.replace(professionName, "").trim
            }
          }
        }catch {
          case e: Exception =>
            println("Weird city description " + cityDescription + " error: " + e.getMessage)
        }
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
