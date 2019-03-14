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
    .exec(bookings.getBookingsForCurrentDate)
    .pause(2)
    .exec(users.getAllUsers)
    .pause(2)
    .exec(bookings.getBookingsForUser)
    .pause(2)
    .pace(5 seconds)
  
}