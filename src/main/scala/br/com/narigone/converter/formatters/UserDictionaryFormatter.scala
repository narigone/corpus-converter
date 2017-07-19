package br.com.narigone.converter.formatters

import java.io.{BufferedWriter, File, FileWriter}

import br.com.narigone.converter.factories.UserFactory
import br.com.narigone.converter.models.User

/**
  * Created by raphael on 6/7/17.
  */
class UserDictionaryFormatter(val fileName: String) extends DictionaryFormatterTrait{

  override def printToFile() : Unit = {
    val userList = UserFactory.getUserList

    val file = new File(this.fileName)
    val bw = new BufferedWriter(new FileWriter(file))

    bw.write("\"Código\";\"Usuário\"\r\n")

    for( user <- userList ){
      val row = this.buildFormattedString(user)
      bw.write(row)
    }

    bw.close()
  }

  def buildFormattedString(user: User): String = {
    val result = "\"" + user.code + "\";\"" + user.name + "\"\r\n"

    result
  }
}
