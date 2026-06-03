package tests;

import models.login.LoginBodyModel;
import models.login.LoginResponseModel;
import models.login.WrongCredantionalsLoginResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static spec.LoginSpec.*;

public class LoginTest extends TestBase {

  String username = "qaguru888";
  String password = "qaguru123";
  String wrongPassword = "qaguru888";

  @Test
  @DisplayName("Классический авторизационный тест")
  void successfulRegistrationTest() {
    LoginBodyModel registrationData =
      step("Предусловия", () ->
        new LoginBodyModel(username, password));

    LoginResponseModel loginResponse =
      step("Шаги",
        () -> given()
          .spec(loginRequestSpec)
          .body(registrationData)
          .when()
          .post("/auth/token/")
          .then()
          .log().all()
          .spec(successfulLoginResponseSpec)
          .extract()
          .as(LoginResponseModel.class)
        );

    step("Проверки", () -> {
      String expectedTokenPath = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9";
      String actualAccess = loginResponse.access();
      String actualRefresh = loginResponse.refresh();

      assertThat(actualAccess).startsWith(expectedTokenPath);
      assertThat(actualRefresh).startsWith(expectedTokenPath);
      assertThat(actualRefresh).isNotEqualTo(actualAccess);
    });
  }

  @Test
  @DisplayName("Тест с невалидным логином")
  void wrongRegistrationTest_Password() {
    LoginBodyModel loginData =
      step("Предусловия",
        () -> new LoginBodyModel(username, wrongPassword));

    WrongCredantionalsLoginResponseModel loginResponse = step("Шаги", () ->
      given(loginRequestSpec)
        .body(loginData)
        .when()
        .post("/auth/token/")
        .then()
        .spec(wrongRegistrationLoginSpec)
        .extract().as(WrongCredantionalsLoginResponseModel.class)
    );

    step("Проверки", () -> {
      String expectedDetailError = "Invalid username or password.";
      String actualActualDetailError = loginResponse.detail();
      assertThat(actualActualDetailError).isEqualTo(expectedDetailError);
    });
  }
}
