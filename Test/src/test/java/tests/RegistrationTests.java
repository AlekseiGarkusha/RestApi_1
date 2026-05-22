package tests;

import helpers.GenerateRandomSeries;
import io.restassured.http.ContentType;
import models.login.LoginBodyModel;
import models.registration.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import setup.TestBase;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationTests extends TestBase {

  String username = "qaguru" + GenerateRandomSeries.generateRandomSeries();
  String password = "qaguru123";
  String existingUsername = "qaguru8";

  @Test
  @DisplayName("Проверка на создание нового юзера")
  void successfulRegistrationTest() {
    LoginBodyModel loginData = new LoginBodyModel(username, password);

    SuccessfulRegistrationResponseModel registrationResponse =
      given()
        .log().all()
        .contentType(ContentType.JSON)
        .body(loginData)
        .basePath("/api/v1")
        .when()
        .post("/users/register/")
        .then()
        .log().all()
        .statusCode(201)
        .body(matchesJsonSchemaInClasspath(
          "registration/successfull_registration_response_createUser_Schema.json"))
        .body("id", notNullValue())
        .body("username", notNullValue())
        .body("remoteAddr", notNullValue())
        .extract().as(SuccessfulRegistrationResponseModel.class);

    String actualUsername = registrationResponse.username();
    assertThat(actualUsername).isEqualTo(username);
    assertThat(registrationResponse.firstName()).isEqualTo("");
    assertThat(registrationResponse.lastName()).isEqualTo("");
    assertThat(registrationResponse.email()).isEqualTo("");
  }

  @Test
  @DisplayName("Проверка на дубликат юзера по существующему 'username'")
  void successfulRegistrationTest_ExistingUser() {
    LoginBodyModel loginData = new LoginBodyModel(existingUsername, password);
    List<String> expectedMessage = List.of("A user with that username already exists.");

    OnlyUserNameResponseModel registrationResponse =
      given()
        .log().all()
        .contentType(ContentType.JSON)
        .body(loginData)
        .basePath("/api/v1")
        .when()
        .post("/users/register/")
        .then()
        .log().all()
        .statusCode(400)
        .body(matchesJsonSchemaInClasspath(
          "registration/successfull_registration_response_create_existingUser_Schema.json"))
        .extract()
        .as(OnlyUserNameResponseModel.class);

    assertEquals(expectedMessage, registrationResponse.username());
  }

  @Test
  @DisplayName("Проверка на пустой логин")
  void successfulRegistrationTest_EmptyLogin() {
    LoginBodyModel loginData = new LoginBodyModel("", password);
    List<String> expectedMessage = List.of("This field may not be blank.");

    OnlyUserNameResponseModel registrationResponse =
      given()
        .log().all()
        .contentType(ContentType.JSON)
        .body(loginData)
        .basePath("/api/v1")
        .when()
        .post("/users/register/")
        .then()
        .log().all()
        .statusCode(400)
        .body(matchesJsonSchemaInClasspath(
          "registration/negative_registration_response_test_blank_login.json"))
        .extract().as(OnlyUserNameResponseModel.class);

    assertEquals(expectedMessage, registrationResponse.username());
  }

  @Test
  @DisplayName("Проверка на пустой пароль")
  void successfulRegistrationTest_BlankPassword() {
    LoginBodyModel loginData = new LoginBodyModel(username, "");
    List<String> expectedMessage = List.of("This field may not be blank.");

    OnlyPasswordResponseModel registrationResponse =
      given()
        .log().all()
        .contentType(ContentType.JSON)
        .body(loginData)
        .basePath("/api/v1")
        .when()
        .post("/users/register/")
        .then()
        .log().all()
        .statusCode(400)
        .body(matchesJsonSchemaInClasspath(
          "registration/negative_registration_response_test_blank_password.json"))
        .extract().as(OnlyPasswordResponseModel.class);

    assertEquals(expectedMessage, registrationResponse.password());
  }

  @Test
  @DisplayName("Проверка на невалидный логин")
  void successfulRegistrationTest_WrongLogin() {
    LoginBodyModel loginData = new LoginBodyModel("!!@#!@#", password);
    List<String> expectedMessage = List.of(
      "Enter a valid username. This value may contain only letters, numbers, and @/./+/-/_ characters.");

    OnlyUserNameResponseModel registrationResponse =
      given()
        .log().all()
        .contentType(ContentType.JSON)
        .body(loginData)
        .basePath("/api/v1")
        .when()
        .post("/users/register/")
        .then()
        .log().all()
        .statusCode(400)
        .body(matchesJsonSchemaInClasspath(
          "registration/negative_registration_response_test_blank_login.json"))
        .extract().as(OnlyUserNameResponseModel.class);

    assertEquals(expectedMessage, registrationResponse.username());
  }
}
