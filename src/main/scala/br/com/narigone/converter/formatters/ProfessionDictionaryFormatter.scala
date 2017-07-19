package br.com.narigone.converter.formatters
import java.io.{BufferedWriter, File, FileWriter}

import br.com.narigone.converter.factories.ProfessionFactory
import br.com.narigone.converter.models.Profession

/**
  * Created by raphael on 6/7/17.
  */
class ProfessionDictionaryFormatter(val fileName: String) extends DictionaryFormatterTrait{

  override def printToFile() : Unit = {
    val professionList =  ProfessionFactory.getProfessionList

    val file = new File(this.fileName)
    val bw = new BufferedWriter(new FileWriter(file))

    bw.write("\"Código\";\"Profissão\"\r\n")

    for( profession <- professionList ){
      val row = this.buildFormattedString(profession)
      bw.write(row)
    }

    bw.close()
  }

  def buildFormattedString(profession: Profession): String = {
    val result =  "\"" + profession.code + "\";\"" + profession.name + "\"\r\n"

    result
  }
}
