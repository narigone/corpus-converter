package br.com.narigone.converter.formatters

import java.io.{BufferedWriter, File, FileWriter}

import br.com.narigone.converter.factories.CityFactory
import br.com.narigone.converter.models.City

/**
  * Created by raphael on 6/7/17.
  */
class CityDictionaryFormatter(val fileName: String) extends DictionaryFormatterTrait{

  override def printToFile() : Unit = {
    val cityList =  CityFactory.getCityList

    val file = new File(this.fileName)
    val bw = new BufferedWriter(new FileWriter(file))

    bw.write("\"Código\";\"Cidade\";\"Estado\"\r\n")

    for( city <- cityList ){
      val row = this.buildFormattedString(city)
      bw.write(row)
    }

    bw.close()
  }

  def buildFormattedString(city: City): String = {
    val result = "\"" + city.code + "\";\"" + city.name + "\";\"" + city.state + "\"\r\n"

    result
  }
}
