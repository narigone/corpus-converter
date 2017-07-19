package br.com.narigone.converter.formatters

import br.com.narigone.converter.models.Complaint

/**
  * Created by raphael on 6/7/17.
  */
trait OutputFormatterTrait {
  def printToFile(complaintList: Array[Complaint])
}
