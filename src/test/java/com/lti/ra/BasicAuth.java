package com.lti.ra;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class BasicAuth {
  @Test
  public void PreemptiveAuth() {
	  given()
	  		.proxy("192.168.100.1",8081)
	  		.auth()
	  		.preemptive().basic("ToolsQA", "TestPassword")
	  .when()
	  		.get("http://restapi.demoqa.com/authentication/CheckForAuthentication/")
	  .then()
	  		.statusCode(200);
  }
}
