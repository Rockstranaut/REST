package com.lti.ra;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ChickenApp {
 
	 @Test(enabled=false)
	  public void f() {
		  
		  given()
		  		.proxy("192.168.100.1",8081)
		  		.auth()
		  		.oauth2("d53d70233ed83ecc5b75db94b375390822e7c93f")
		  .when()
		  		.post("http://coop.apps.symfonycasts.com/api/424/chickens-feed")
		  .then()
		  		.statusCode(200);
	  }
	 
	 @Test
	  public void f2() {
		  Response r= given()
				  .proxy("192.168.100.1",8081)
				  .formParam("client_id", "DemoApp333")
				  .formParam("client_secret", "8a15f8df31f212d771ab5173f8ef6b6f")
				  .formParam("grant_type", "client_credentials")
				  .when()
				  .post("http://coop.apps.symfonycasts.com/token");
		  System.out.println(r.jsonPath().prettify());
		  
		  String token=r.jsonPath().getString("access_token");
		  System.out.println("Token is=>"+token);
		  
		  given()
	  		.proxy("192.168.100.1",8081)
	  		.auth()
	  		.oauth2(token)
	  .when()
	  		.post("http://coop.apps.symfonycasts.com/api/424/chickens-feed")
	  .then()
	  		.statusCode(200);
		 
	  }
}
