package com.lti.ra;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

public class StudentApp {
  @Test(enabled=false)
  public void f() {
	  given().when().get("http://localhost:9090/student/list").then().statusCode(200);
	  Response r = given().when().delete("http://localhost:9090/student/1");
	 /* System.out.println(r.prettyPrint().toString());
	  String fname=r.jsonPath().get("firstName");
	  Assert.assertEquals(fname, "Vernon");
	  System.out.println(r.getTime());*/
	  
  }
  
  
  @Test
  public void postCall()
  {
	  ArrayList<String> courses = new ArrayList<String>();
	  courses.add("Digital Electronics");
	  courses.add("Comp Networking");
	  courses.add("Digital Signal Processing");
	  courses.add("Analog Communications");
	  
	  StudentPOJO stud= new StudentPOJO();
	  stud.setFirstName("Snehal");
	  stud.setLastName("Magare");
	  stud.setEmail("Snehal@12");
	  stud.setProgramme("IT");
	  stud.setCourses(courses);
	  
	  
	  given()
	  .contentType(ContentType.JSON)
	  .when()
	  		.body(stud)
	  		.put("http://localhost:9090/student/101")
	  		.then()
	  		.statusCode(200);
  }
}
