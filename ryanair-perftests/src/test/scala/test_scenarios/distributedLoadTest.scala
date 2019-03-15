package test_scenarios

import io.gatling.core.Predef._
import business_flows._
import configurations.config._
import io.gatling.http.Predef._
import scala.concurrent._
import scala.concurrent.duration._


class distributedLoadTest extends Simulation {
  
  val distributedLoadTestScenario = 
     performanceTestFlows.performanceTestFlow.inject(
       constantUsersPerSec(1) during (1 minutes)).throttle(
       reachRps(1) in (1 second),
       holdFor(1 minute),
       jumpToRps(3),
       holdFor(1 minute),
       jumpToRps(1),
       holdFor(1 minute))
       
       
  setUp(distributedLoadTestScenario).protocols(httpProtocol)
  
}