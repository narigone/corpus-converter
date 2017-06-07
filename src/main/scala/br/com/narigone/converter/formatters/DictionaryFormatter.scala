package br.com.narigone.converter.formatters
import br.com.narigone.converter.factories.{ProfessionFactory, UserFactory}
import br.com.narigone.converter.models.Complaint

/**
  * Created by raphael on 6/7/17.
  */
class DictionaryFormatter extends DictionaryFormatterTrait{
  override def buildFormattedString(): String = {
    val professionList = ProfessionFactory.getProfessionList()
    val userList = UserFactory.getUserList()

    var result = "\"Código\";\"Profissão\"\r\n"

    for( profession <- professionList ){
      result = result + "\"" + profession.code + "\";\"" + profession.name + "\"\r\n"
    }

    result = result + "\r\n\"Código\";\"Usuário\"\r\n"

    for( user <- userList ){
      result = result + "\"" + user.code + "\";\"" + user.name + "\"\r\n"
    }

    result
  }
}
