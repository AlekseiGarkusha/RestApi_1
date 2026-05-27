package tests;

import models.login.LoginBodyModel;

import org.junit.jupiter.api.Test;
import setup.TestBase;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.notNullValue;
import static spec.loginSpec.LoginSpec.loginRequestSpec;

public class LogoutTest extends TestBase {

  @Test
  public void successfulLogoutTest() {
    String username = "qaguru";
    String password = "qaguru123";

    LoginBodyModel loginData = new LoginBodyModel(username, password);

    /// LOGIN
    String refreshToken =
      given()
        .spec(loginRequestSpec)
        .body(loginData)
        .when()
        .post("/auth/token/")
        .then()
        .statusCode(200)
        .body(matchesJsonSchemaInClasspath("registration/successfull_registration_response_schema.json"))
        .body("access", notNullValue())
        .body("refresh", notNullValue())
        .extract().path("refresh");


    /// LOGOUT BODY
    Map<String, String> logoutBody = new HashMap<>();
    logoutBody.put("refresh", refreshToken);

    /// LOGOUT
    given()
      .spec(loginRequestSpec)
      .body(logoutBody)
      .basePath("/api/v1")
      .when()
      .post("/auth/logout/")
      .then()
      .statusCode(200);

    /// CHECK
    given()
      .spec(loginRequestSpec)
      .body(logoutBody)
      .basePath("/api/v1")
      .when()
      .post("/auth/token/refresh/")
      .then()
      .statusCode(401);
  }
}
