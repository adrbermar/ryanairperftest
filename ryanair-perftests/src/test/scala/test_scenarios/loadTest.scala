package test_scenarios

import io.gatling.core.Predef._
import business_flows._
import configurations.config._
import io.gatling.http.Predef._
import scala.concurrent._
import scala.concurrent.duration._


class loadTest extends Simulation {
  
  val loadTestScenario = 
     performanceTestFlows.performanceTestFlow.inject(
       constantConcurrentUsers(10) during (5 minutes))
     
  setUp(loadTestScenario).protocols(httpProtocol)
  
}