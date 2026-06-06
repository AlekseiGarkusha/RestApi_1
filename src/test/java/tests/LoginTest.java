package tests;

import models.login.LoginBodyModel;
import models.login.LoginResponseModel;
import models.login.WrongCredantionalsLoginResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends TestBase {

  String username = "qaguru888";
  String password = "qaguru123";
  String wrongPassword = "qaguru888";

  @Test
  @DisplayName("Классический авторизационный тест")
  void successfulRegistrationTest() {
    LoginBodyModel registrationData = step("Предусловия", () ->
      new LoginBodyModel(username, password));

    LoginResponseModel loginResponse = step("Шаги", () ->
      api.login(registrationData));

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
    LoginBodyModel loginData = step("Предусловия", () ->
      new LoginBodyModel(username, wrongPassword));

    WrongCredantionalsLoginResponseModel loginResponse = step("Шаги", () ->
      api.loginWithWrongCredentials(loginData));

    step("Проверки", () -> {
      String expectedDetailError = "Invalid username or password.";
      String actualActualDetailError = loginResponse.detail();
      assertThat(actualActualDetailError).isEqualTo(expectedDetailError);
    });
  }
}
