package tests;

import io.restassured.http.ContentType;
import models.login.LoginBodyModel;
import models.records.RegistrationBodyRecordModel;
import org.junit.jupiter.api.Test;
import setup.TestBase;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.notNullValue;

public class LoginTests extends TestBase {

  String username;
  String password;

  @Test
  public void successfulLoginTest() {

    LoginBodyModel loginBodyModel = new LoginBodyModel(username, password);

    given()
        .body(loginBodyModel)
        .log().all()
        .header("Content-Type", "application/json")
        .contentType(ContentType.JSON)
        .accept(ContentType.JSON)
        .when()
        .post("http://bookclub.qa.guru:8000/api/v1/users/register/")
        .then()
        .log().all()
        .statusCode(200)
      .body(matchesJsonSchemaInClasspath("LoginResponce_Schema.json"))
        .body("refresh", notNullValue())
        .body("access", notNullValue());
  }

}
