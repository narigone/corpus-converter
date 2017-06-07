package br.com.narigone.converter.formatters
import br.com.narigone.converter.models.Complaint

/**
  * Created by raphael on 6/7/17.
  */
class OutputFormatter extends OutputFormatterTrait {
  override def buildFormattedString(recordList: List[Complaint]): String = {
    var result = ""

    for( complaint <- recordList ){
      result = result + "**** *" + complaint.user.code + " *" + complaint.profession.code + "\r\n";
      result = result + complaint.text + "\r\n";
    }

    result
  }
}
