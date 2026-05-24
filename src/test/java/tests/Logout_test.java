package tests;

import models.login.LoginBodyModel;
import org.junit.jupiter.api.Test;
import setup.TestBase;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static spec.loginSpec.LoginSpec.loginRequestSpec;
import static spec.loginSpec.LoginSpec.successfulLoginResponseSpec;

public class Logout_test extends TestBase {

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
        .basePath("/api/v1")
        .when()
        .post("/auth/token/")
        .then()
        .statusCode(200)
        .spec(successfulLoginResponseSpec)
        .extract()
        .path("refresh");

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
