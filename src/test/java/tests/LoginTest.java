package tests;

import helpers.GenerateRandomSeries;
import io.restassured.RestAssured;
import models.login.LoginBodyModel;
import models.login.LoginResponseModel;
import models.login.WrongCredantionalsLoginResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import setup.TestBase;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static spec.loginSpec.LoginSpec.*;
import static spec.loginSpec.RegistrationSpec.classicRegistrationSpec;

public class LoginTest extends TestBase {

  String username = "qaguru";
  String newUsername = "qaguru" + GenerateRandomSeries.generateRandomSeries();
  String password = "qaguru123";
  String wrongPassword = "qaguru888";

  @Test
  @DisplayName("Классический регистрационный тест")
  void successfulRegistrationTest() {
    LoginBodyModel registrationData = new LoginBodyModel(newUsername, password);

    LoginResponseModel loginResponse = step("Шаги", () ->
      given()
        .spec(loginRequestSpec)
        .body(registrationData)
        .when()
        .post("/users/register/")
        .then()
        .log().all()
        .spec(classicRegistrationSpec)
        .extract().as(LoginResponseModel.class)

    );
    System.out.println(RestAssured.baseURI);
    step("Проверки", () -> {
//      String expectedTokenPath = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9";
//      String actualAccess = loginResponse.access();
//      String actualRefresh = loginResponse.refresh();

//      assertThat(actualAccess).startsWith(expectedTokenPath);
//      assertThat(actualRefresh).startsWith(expectedTokenPath);
//      assertThat(actualRefresh).isNotEqualTo(actualAccess);
    });
  }

  @Test
  void wrongRegistrationTest_login() {
    LoginBodyModel loginData = new LoginBodyModel(username, wrongPassword);

    WrongCredantionalsLoginResponseModel loginResponse = step("Шаги", () ->
      given(loginRequestSpec)
        .body(loginData)
        .when()
        .post("/auth/token/")
        .then()
        .spec(wrongRegistrationLoginSpec)
        .extract().as(WrongCredantionalsLoginResponseModel.class)
    );

    step("Шаги", () -> {
      String expectedDetailError = "Invalid username or password.";
      String actualActualDetailError = loginResponse.detail();
      assertThat(actualActualDetailError).isEqualTo(expectedDetailError);

    });
  }
}
