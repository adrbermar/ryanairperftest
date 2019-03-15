package requests

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.util.Random
import java.text.SimpleDateFormat
import configurations.config._
import configurations.generalFunctions._

object bookings {
    
  private val currentDate = today();
  private val pastDate = daysAgo(10);
  
  private val iataCod = csv("iata.csv").random

  
  val createBookingForCurrentDate =
      exec{session => session.set("currentDate",currentDate)}
      .feed(iataCod)
      .exec(http("POST_Create_Booking")
			.post(application_url + "/booking")
			.body(StringBody("""{"date": "${currentDate}","destination": "${IATA_Destination}","id": "${userId}","origin": "${IATA_Origin}"}""")).asJson
			.header("Content-Type", "application/json")
			.check(status.is(201)))
			
	val createBookingForPastDate = 
      exec{session => session.set("pastDate",pastDate)}
      .exec(http("POST_Create_Booking")
			.post(application_url + "/booking")
			.body(StringBody("""{"date": "${pastDate}","destination": "${IATA_Destination}","id": "${userId}","origin": "${IATA_Origin}"}""")).asJson
			.header("Content-Type", "application/json")
			.check(status.is(201)))
			
	val getBookingsForDate = 
	    exec{session => session.set("currentDate",currentDate)}
	    .exec(http("GET_All_Bookings_For_A_Date")  
			.get(application_url + "/booking")
			.queryParam("date","${currentDate}")
			.check(status.is(200)))
			
	val getBookingsForUser = 
	    exec(http("GET_All_Bookings_For_A_User")
			.get(application_url + "/booking")
			.queryParam("id","${userId}")
			.check(status.is(200)))
  
}