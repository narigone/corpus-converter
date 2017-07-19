package br.com.narigone.converter.formatters
import java.io.{BufferedWriter, File, FileWriter}

import br.com.narigone.converter.models.Complaint

/**
  * Created by raphael on 6/7/17.
  */
class OutputFormatter(val fileName: String) extends OutputFormatterTrait {

  override def printToFile(complaintList: Array[Complaint]) : Unit = {
    val file = new File(this.fileName)
    val bw = new BufferedWriter(new FileWriter(file))

    for( complaint <- complaintList ){
      val row = this.buildFormattedString(complaint)
      bw.write(row)
    }

    bw.close()
  }

  def buildFormattedString(complaint: Complaint): String = {
    var result = "**** *" + complaint.user.code + " *" + complaint.user.profession.code + " *" + complaint.user.city.code + "\r\n"
    result = result + complaint.text + "\r\n"

    result
  }
}
