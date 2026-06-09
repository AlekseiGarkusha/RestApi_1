package clients;

import io.qameta.allure.Step;

import io.restassured.http.ContentType;
import models.login.*;
import models.registration.create.OnlyPasswordResponseModel;
import models.registration.create.OnlyUserNameResponseModel;
import models.registration.create.SuccessfulRegistrationResponseModel;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.core.IsNull.notNullValue;
import static spec.BaseSpecs.baseRequestSpec;
import static spec.LoginSpec.*;

public class AuthClient {
  @Step("Классическая авторизация")
  public LoginResponseModel login(LoginBodyModel body) {
    return given()
      .spec(loginRequestSpec)
      .body(body)
      .when()
      .post("/auth/token/")
      .then()
      .spec(successfulLoginResponseSpec)
      .extract()
      .as(LoginResponseModel.class);
  }

  @Step("Создание нового юзера")
  public SuccessfulRegistrationResponseModel createNewUser(LoginBodyModel body) {
    return given()
      .spec(baseRequestSpec)
      .body(body)
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
      .extract()
      .as(SuccessfulRegistrationResponseModel.class);
  }

  @Step("")
  public WrongCredantionalsLoginResponseModel loginWithWrongCredentials(LoginBodyModel body) {
    return given(loginRequestSpec)
      .body(body)
      .when()
      .post("/auth/token/")
      .then()
      .spec(wrongRegistrationLoginSpec)
      .extract()
      .as(WrongCredantionalsLoginResponseModel.class);
  }

  @Step("Регистрация с пустым паролем")
  public OnlyPasswordResponseModel testBlankPassword(LoginBodyModel body) {
    return given()
      .log().all()
      .contentType(ContentType.JSON)
      .body(body)
      .basePath("/api/v1")
      .when()
      .post("/users/register/")
      .then()
      .log().all()
      .statusCode(400)
      .body(matchesJsonSchemaInClasspath(
        "registration/negative_registration_response_test_blank_password.json"))
      .extract().as(OnlyPasswordResponseModel.class);
  }

  @Step("Регистрация с пустым логином")
  public OnlyUserNameResponseModel testBlankLogin(LoginBodyModel body) {
    return given()
      .spec(baseRequestSpec)
      .body(body)
      .when()
      .post("/users/register/")
      .then()
      .log().all()
      .statusCode(400)
      .body(matchesJsonSchemaInClasspath(
        "registration/negative_registration_response_test_blank_login.json"))
      .extract().as(OnlyUserNameResponseModel.class);
  }

  @Step("Регистрация с невалидным логином")
  public OnlyUserNameResponseModel testBlankOrWrongLogin(LoginBodyModel body) {
    return given()
      .spec(baseRequestSpec)
      .body(body)
      .when()
      .post("/users/register/")
      .then()
      .log().all()
      .statusCode(400)
      .body(matchesJsonSchemaInClasspath(
        "registration/negative_registration_response_test_blank_login.json"))
      .extract().as(OnlyUserNameResponseModel.class);
  }

  @Step("Обновление данных PATCH")
  public UpdateResponseModel_Patch updateUser_PATCH(UpdateResponseModel_Patch body, String token) {
    return given()
      .spec(baseRequestSpec)
      .header("Authorization", "Bearer " + token)
      .body(body)
      .when()
      .patch("/users/me/")
      .then()
      .log().all()
      .statusCode(200)
      .extract()
      .as(UpdateResponseModel_Patch.class);
  }

  @Step("Обновление данных PATCH")
  public UpdateResponseModel_Put updateUser_PUT(UpdateResponseModel_Put body, String token) {
    return given()
      .spec(baseRequestSpec)
      .header("Authorization", "Bearer " + token)
      .body(body)
      .when()
      .put("/users/me/")
      .then()
      .log().all()
      .statusCode(200)
      .extract()
      .as(UpdateResponseModel_Put.class);
  }
}