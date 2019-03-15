package business_flows

import io.gatling.core.Predef._
import scala.concurrent.duration._
import requests.users
import requests.bookings

object performanceTestFlows {
  
  val performanceTestFlow = scenario("Performance Test Flow")
    .exec(users.createUsers)
    .pause(2)
    .exec(bookings.createBookingForCurrentDate)
    .pause(2)
    .exec(bookings.createBookingForPastDate)
    .pause(2)
    .exec(bookings.getBookingsForDate)
    .pause(2)
    .exec(users.getAllUsers)
    .pause(2)
    .exec(bookings.getBookingsForUser)
    
    .pace(5 seconds)
  
}