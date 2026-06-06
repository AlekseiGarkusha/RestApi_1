package tests;

import helpers.GenerateRandomSeries;
import models.login.LoginBodyModel;
import models.login.LoginResponseModel;
import models.login.UpdateResponseModel;
import models.registration.create.SuccessfulRegistrationResponseModel;
import models.registration.update.put.UpdateResponseModelPut;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static spec.BaseSpecs.baseRequestSpec;

public class UpdateUserTest extends TestBase {
  final String
    testUsername = "testuser" + GenerateRandomSeries.generateRandomSeries(),
    password = "qaguru123",
    updateUsername = "updateUsername" + GenerateRandomSeries.generateRandomSeries(),
    updateFirstName = "updateFirstBame",
    updateLastName = "updateLastname",
    updateEmail = "user@example.com",
    updateAddr = "testAdrr",
    updateId = "";

  /// PATCH
  @Test
  @DisplayName("Тест - обновление данных пользователя")
  void updateUser_PATCH() {
    LoginBodyModel userData = new LoginBodyModel(testUsername, password);

    UpdateResponseModel updateUserData = new UpdateResponseModel(
      updateId, updateUsername, updateFirstName,
      updateLastName, updateEmail, updateAddr);

    SuccessfulRegistrationResponseModel registrationResponse =
      step("Регистрация нового пользователя", () ->
        api.createNewUser(userData));

    LoginResponseModel loginResponse = step("Авторизация", () ->
      api.login(userData));

    String token = loginResponse.access();

    UpdateResponseModel updateResponseModel =
      step("Обновление данных пользователя метод PATCH", () ->
        api.updateUser_PATCH(String.valueOf(updateUserData), token));

    step("Проверка данных", () -> {
      assertThat(updateResponseModel.username()).isEqualTo(updateUsername);
      assertThat(updateResponseModel.firstName()).isEqualTo(updateFirstName);
      assertThat(updateResponseModel.lastName()).isEqualTo(updateLastName);
      assertThat(updateResponseModel.email()).isEqualTo(updateEmail);
    });
  }

  /// PUT
  @Test
  @DisplayName("Тест - обновление данных пользователя")
  void updateUser_PUT() {
    LoginBodyModel userData = new LoginBodyModel(testUsername, password);

    UpdateResponseModelPut updateUserDataPut = new UpdateResponseModelPut(
      updateId,
      updateUsername,
      updateFirstName,
      updateLastName,
      updateEmail,
      updateAddr);

    SuccessfulRegistrationResponseModel registrationResponse =
      step("Регистрация нового пользователя", () ->
        api.createNewUser(userData));

    LoginResponseModel loginResponse = step("Авторизация", () ->
        api.login(userData));

    String token = loginResponse.access();

    UpdateResponseModelPut updateResponseModelPut = step("Обновление данных пользователя - метод PUT", () ->
      api.updateUser_PUT(String.valueOf(userData), token));

    step("Проверка данных", () -> {
      assertThat(updateResponseModelPut.username()).isEqualTo(updateUsername);
      assertThat(updateResponseModelPut.firstName()).isEqualTo(updateFirstName);
      assertThat(updateResponseModelPut.lastName()).isEqualTo(updateLastName);
      assertThat(updateResponseModelPut.email()).isEqualTo(updateEmail);
    });
  }
}
