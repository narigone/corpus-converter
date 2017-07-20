package br.com.narigone.converter.factories

import br.com.narigone.converter.models.Profession

/**
  * Created by raphael on 6/7/17.
  */
object ProfessionFactory {
  private var professionMap = Map[String, Profession]()

  def buildProfessionFromName(professionName: String) : Profession = {
    val mapKey = professionName.trim().toUpperCase()

    if(this.professionMap.contains(mapKey)){
      return professionMap(mapKey)
    }

    if(mapKey.isEmpty){
      return buildUndefinedProfession()
    }

    buildNewProfessionFromName(professionName.trim, mapKey)
  }

  def buildUndefinedProfession(): Profession = {
    val code = "Prof_UNDEF"

    if(this.professionMap.contains(code)){
      return professionMap(code)
    }

    val profession = new Profession("Não informada", code)
    professionMap += (code -> profession)
    profession
  }

  private def buildNewProfessionFromName(professionName: String, mapKey: String) = {
    val mapSize = professionMap.size
    val code = "Prof_" + (mapSize + 1)
    val Profession = new Profession(professionName, code)
    professionMap += (mapKey -> Profession)
    Profession
  }

  def getProfessionList : List[Profession] = {
    var professionList : List[Profession] = List()

    professionMap.foreach{
      case(key :String, profession:Profession) => professionList = professionList :+ profession
    }

    professionList
  }
}
