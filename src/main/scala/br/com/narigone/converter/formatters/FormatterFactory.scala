package br.com.narigone.converter.formatters

/**
  * Created by raphael on 6/7/17.
  */
object FormatterFactory {

  def buildOutputFormatter(fileName: String) : OutputFormatterTrait = {
    new OutputFormatter(fileName)
  }

  def buildCityDictionaryFormatter(fileName: String) : DictionaryFormatterTrait = {
    new CityDictionaryFormatter(fileName)
  }

  def buildProfessionDictionaryFormatter(fileName: String) : DictionaryFormatterTrait = {
    new ProfessionDictionaryFormatter(fileName)
  }

  def buildUserDictionaryFormatter(fileName: String) : DictionaryFormatterTrait = {
    new UserDictionaryFormatter(fileName)
  }
}
