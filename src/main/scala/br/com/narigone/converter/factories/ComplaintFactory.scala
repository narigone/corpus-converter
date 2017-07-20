package br.com.narigone.converter.factories

import br.com.narigone.converter.models.Complaint

/**
  * Created by raphael on 6/7/17.
  */
object ComplaintFactory {
  private val regexString = "(De|DE): (.+) \\* (.+)\\\"?"
  private val pattern = regexString.r

  def getRecordFromLine(line: String) : Complaint = {
    try {
      val result = pattern.findAllIn(line)

      val userDescription = result.group(2).trim()
      val complaintText = result.group(3).trim()

      val user = UserFactory.buildUserFromDescription(userDescription)

      val complaint = new Complaint(user, complaintText)

      complaint
    } catch {
      case e: Exception =>
        println("Record " + line + " failed to match regex " + this.regexString + " error: " + e.getMessage)
        null
    }
  }
}
