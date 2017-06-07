package br.com.narigone.converter.processors

import java.io.PrintWriter

import br.com.narigone.converter.configs.AppConfig
import br.com.narigone.converter.formatters.FormatterFactory
import br.com.narigone.converter.models.Complaint
import com.typesafe.scalalogging._

import scala.io.Source

object SingleThreadProcessor extends LazyLogging {
  def processFile() = {
    //val filter = FilterFactory.getFilterFromConfig(AppConfig.filter)

    var recordList: Array[Complaint] = Array()


    for (line <- Source.fromFile(AppConfig.inputFile).getLines().drop(1)) {
      val record = LineProcessor.processLine(line)
      if (record != null) {
        recordList = recordList :+ record
      }
    }

    val outputFormatter = FormatterFactory.buildOutputFormatter();
    val result = outputFormatter.buildFormattedString(recordList.toList)
    saveOutputResult(result)

    val dictionaryFormatter = FormatterFactory.buildDictionaryFormatter();
    val dictionary = dictionaryFormatter.buildFormattedString()
    saveDictionaryResult(dictionary)
  }

  def saveOutputResult(content: String) = {
    new PrintWriter(AppConfig.outputFile) { write(content); close }
  }

  def saveDictionaryResult(content: String) = {
    new PrintWriter(AppConfig.dictionaryFile) { write(content); close }
  }
}

