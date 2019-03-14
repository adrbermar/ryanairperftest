package requests

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.util.Random
import configurations.config.application_url

object users {
    
  private val randomName = Iterator.continually(Map("randomName" -> ("PTest_" + Random.alphanumeric.take(5).mkString)))
  
  val createUsers =
      feed(randomName)
      .exec(http("POST_Create_Users")
			.post(application_url + "/user")
			.body(StringBody("""{"email": "${randomName}@ptest.com","name": "${randomName}"}""")).asJson
			.header("Content-Type", "application/json")
			//.check(jsonPath("$.id").saveAs("userId"))
			.check(regex("\"id\":\"([^\"]+)").find.saveAs("userId"))
			.check(status.is(201)))
			
	val getAllUsers = exec(http("GET_All_Users")
			.get(application_url + "/user/all")
			.check(regex("\"id\":\"([^\"]+)").findRandom.saveAs("userId"))
			.check(status.is(200)))
			  
}