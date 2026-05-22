package tests;

import io.restassured.http.ContentType;
import models.login.LoginBodyModel;
import models.login.LoginResponseModel;
import models.login.WrongCredantionalsLoginResponseModel;
import org.junit.jupiter.api.Test;
import setup.TestBase;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.notNullValue;
import static spec.loginSpec.LoginSpec.*;

public class Login_test extends TestBase {

  String username = "qaguru";
  String password = "qaguru123";
  String wrongPassword = "qaguru888";

  @Test
  void successfulRegistrationTest() {
    LoginBodyModel loginData = new LoginBodyModel(username, password);

    LoginResponseModel loginResponse =
    given()
      .spec(loginRequestSpec)
      .body(loginData)
      .when()
      .post("http://bookclub.qa.guru:8000/api/v1/users/register/")
      .then()
      .spec(successfulLoginResponseSpec)
      .extract().as(LoginResponseModel.class);

    String expectedTokenPath = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9";
    String actualAccess = loginResponse.access();
    String actualRefresh = loginResponse.refresh();

    assertThat(actualAccess).startsWith(expectedTokenPath);
    assertThat(actualRefresh).startsWith(expectedTokenPath);
    assertThat(actualRefresh).isNotEqualTo(actualAccess);
  }

  @Test
  void wrongRegistrationTest_login() {
    LoginBodyModel loginData = new LoginBodyModel(username, wrongPassword);

    WrongCredantionalsLoginResponseModel loginResponse = given(loginRequestSpec)
        .body(loginData)
        .when()
        .post("/auth/token/")
        .then()
        .spec(wrongRegistrationLoginSpec)
        .extract().as(WrongCredantionalsLoginResponseModel.class);

    String expectedDetailError = "Invalid username or password.";
    String actualActualDetailError = loginResponse.detail();
    assertThat(actualActualDetailError).isEqualTo(expectedDetailError);

  }
  /**
   * Добавить негативных тестов в регистрациионные и логин тесты
   * Добавить тесты на logout
   * Добавить тесты не обновление пользователя
   *
   *
   */
}
