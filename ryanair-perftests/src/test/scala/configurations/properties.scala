package configurations

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object config {
  
  val application_url = "http://127.0.0.1:8900"
  
  val httpProtocol = http
		.baseUrl("${application_url}")
		.inferHtmlResources()
		.acceptHeader("*/*")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("es-ES,es;q=0.9")
		.userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.109 Safari/537.36")

  
  val users = Integer.getInteger("users", 10).toInt
  //val rampUp = Integer.getInteger("rampup", 1).toInt
  //val throughput = Integer.getInteger("throughput", 100).toInt
  
}