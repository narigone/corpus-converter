package br.com.narigone.converter.processors

import br.com.narigone.converter.configs.AppConfig
import br.com.narigone.converter.formatters.FormatterFactory
import br.com.narigone.converter.models.Complaint
import com.typesafe.scalalogging._

import scala.io.Source

object SingleThreadProcessor extends LazyLogging {
  def processFile() : Unit = {
    val recordList = extractRecordsFromFile

    outputResult(recordList)
  }

  def extractRecordsFromFile : Array[Complaint] = {
    var recordList: Array[Complaint] = Array()

    val lines = Source.fromFile(AppConfig.inputFile).getLines().drop(1).toList
    for (line <- lines) {
      val record = LineProcessor.processLine(line)
      if (record != null) {
        recordList = recordList :+ record
      }
    }
    recordList
  }

  private def outputResult(recordList: Array[Complaint]) = {
    val outputFormatter = FormatterFactory.buildOutputFormatter(AppConfig.outputFile)
    outputFormatter.printToFile(recordList)

    val cityDictionaryFormatter = FormatterFactory.buildCityDictionaryFormatter(AppConfig.cityDictionaryFile)
    cityDictionaryFormatter.printToFile()

    val professionDictionaryFormatter = FormatterFactory.buildProfessionDictionaryFormatter(AppConfig.professionDictionaryFile)
    professionDictionaryFormatter.printToFile()

    val userDictionaryFormatter = FormatterFactory.buildUserDictionaryFormatter(AppConfig.userDictionaryFile)
    userDictionaryFormatter.printToFile()
  }
}

