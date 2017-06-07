package br.com.narigone.converter.processors

import br.com.narigone.converter.factories.ComplaintFactory
import br.com.narigone.converter.models.Complaint

/**
  * Created by raphael on 6/7/17.
  */
object LineProcessor {

  def processLine(line: String): Complaint = {
    val record = ComplaintFactory.getRecordFromLine(line)
    if (record == null) {
      return null
    }

    return record
  }

}
