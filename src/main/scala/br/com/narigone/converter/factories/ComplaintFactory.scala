package br.com.narigone.converter.factories

import br.com.narigone.converter.models.Complaint

/**
  * Created by raphael on 6/7/17.
  */
object ComplaintFactory {
  private val regexString = "(De|DE): (.+) \\- (.+) \\* (.+)\\\"?";
  private val pattern = regexString.r

  def getRecordFromLine(line: String) : Complaint = {
    try {
      val result = pattern.findAllIn(line)

      val userName = result.group(2).trim()
      val professionName = result.group(3).trim()
      val complaintText = result.group(4).trim()

      val user = UserFactory.buildUserFromName(userName)
      val profession = ProfessionFactory.buildProfessionFromName(professionName)

      new Complaint(user, profession, complaintText)
    } catch {
      case e: Exception => {
        println("Record " + line + " failed to match regex " + this.regexString + " error: " + e.getMessage())
        return null
      }
    }
  }
}
