package configurations

import java.text.SimpleDateFormat
import java.util.{Calendar, Date}

object generalFunctions {
  
  private val dateFmt = "yyyy-MM-dd"

  def today(): String = {
    val date = new Date
    val sdf = new SimpleDateFormat(dateFmt)
    sdf.format(date)
  }

  def yesterday(): String = {
    val calender = Calendar.getInstance()
    calender.roll(Calendar.DAY_OF_YEAR, -1)
    val sdf = new SimpleDateFormat(dateFmt)
    sdf.format(calender.getTime())
  }

  def daysAgo(days: Int): String = {
    val calender = Calendar.getInstance()
    calender.roll(Calendar.DAY_OF_YEAR, -days)
    val sdf = new SimpleDateFormat(dateFmt)
    sdf.format(calender.getTime())
  }
  
}