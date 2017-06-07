package br.com.narigone.converter

import br.com.narigone.converter.processors.SingleThreadProcessor

/**
  * Created by raphael on 6/7/17.
  */
object Converter extends App{
  override def main(args: Array[String]) : Unit = {
      SingleThreadProcessor.processFile();
  }
}
