package br.com.narigone.converter.factories

import br.com.narigone.converter.models.{City, Profession}

/**
  * Created by raphael on 6/7/17.
  */
object CityFactory {
  private var cityMap = Map[String, City]()

  def buildCityFromDescription(cityDescription: String) : City = {
    val mapKey = cityDescription.trim().toUpperCase()

    if(this.cityMap.contains(mapKey)){
      return cityMap(mapKey)
    }

    val tokens = cityDescription.split("/")

    if(tokens.length < 2){
      return buildUndefinedCity()
    }

    var cityName = tokens(tokens.length - 2)
    val stateName = tokens(tokens.length - 1)

    if(cityName.equals(stateName)){
      cityName = tokens(0)
    }

    buildNewCityFromName(cityName.trim, stateName.trim, mapKey)
  }

  private def buildNewCityFromName(cityName: String, stateName: String, mapKey: String) : City  = {
    val mapSize = cityMap.size
    val code = "Cid_" + (mapSize + 1)
    val city = new City(cityName, stateName, code)
    cityMap += (mapKey -> city)
    city
  }

  private def buildUndefinedCity() : City = {
    val code = "Cid_UNDEF"

    if(this.cityMap.contains(code)){
      return cityMap(code)
    }

    val city = new City("Não informada", "", code)
    cityMap += (code -> city)
    city
  }

  def getCityList : List[City] = {
    var cityList : List[City] = List()

    cityMap.foreach{
      case(key :String, city:City) => cityList = cityList :+ city
    }

    cityList
  }
}
