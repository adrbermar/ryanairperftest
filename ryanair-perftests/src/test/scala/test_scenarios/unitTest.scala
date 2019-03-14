package test_scenarios

import io.gatling.core.Predef._
import business_flows._
import configurations.config._
import io.gatling.http.Predef._
import scala.concurrent._
import scala.concurrent.duration._

class unitTest extends Simulation {
  
   val unitTestScenario = 
     performanceTestFlows.performanceTestFlow.inject(
       atOnceUsers(1))
     
   setUp(unitTestScenario).protocols(httpProtocol)
     
  
}