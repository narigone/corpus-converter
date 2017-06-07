package br.com.narigone.converter.formatters

/**
  * Created by raphael on 6/7/17.
  */
object FormatterFactory {

  def buildOutputFormatter() : OutputFormatterTrait = {
    new OutputFormatter
  }

  def buildDictionaryFormatter() : DictionaryFormatterTrait = {
    new DictionaryFormatter
  }
}
