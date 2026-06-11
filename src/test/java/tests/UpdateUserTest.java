package tests;

import helpers.GenerateRandomSeries;

import models.login.*;
import models.registration.create.SuccessfulRegistrationResponseModel;
import models.user.UpdateUserBodyModelPatch;
import models.user.UpdateUserBodyModelPut;
import models.user.UpdateUserResponseModelPatch;
import models.user.UpdateUserResponseModelPut;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UpdateUserTest extends TestBase {

  private final String
    testUsername = "testUser" + GenerateRandomSeries.generateRandomSeries(),
    password = "qaguru123",

    updateUsername = "updateUsername" + GenerateRandomSeries.generateRandomSeries(),
    updateFirstName = "updateFirstName",
    updateLastName = "updateLastName",
    updateEmail = "userG-12@yandex.ru",
    updateAddr = "testAdrr",
    updateId = "";

  @Test
  @DisplayName("Тест - обновление данных пользователя - PATCH")
  void updateUser_PATCH() {
    LoginBodyModel userData = new LoginBodyModel(testUsername, password);

    UpdateUserBodyModelPatch requestBody = new UpdateUserBodyModelPatch(
      updateUsername,
      updateFirstName,
      updateLastName,
      updateEmail);

    SuccessfulRegistrationResponseModel registrationResponse = api.createNewUser(userData);

    LoginResponseModel loginResponse = api.login(userData);

    String token = loginResponse.access();

    UpdateUserResponseModelPatch updateResponseModel = api.updateUser_PATCH(requestBody, token);

    System.out.println(updateEmail);

    step("Проверка данКороных", () -> {
      assertThat(updateResponseModel.username()).isEqualTo(updateUsername);
      assertThat(updateResponseModel.firstName()).isEqualTo(updateFirstName);
      assertThat(updateResponseModel.lastName()).isEqualTo(updateLastName);
      assertThat(updateResponseModel.email()).isEqualTo(updateEmail);
    });
  }

  /// PUT
  @Test
  @DisplayName("Тест - обновление данных пользователя PUT")
  void updateUser_PUT() {
    LoginBodyModel userData = new LoginBodyModel(testUsername, password);
    UpdateResponseModel_Put updateUserDataPut = new UpdateResponseModel_Put(
      updateUsername, updateFirstName,
      updateLastName, updateEmail);


    api.createNewUser(userData);


    LoginResponseModel loginResponse = api.login(userData);
    String token = loginResponse.access();

    UpdateUserBodyModelPut requestBody = new UpdateUserBodyModelPut(
      updateUsername,
      updateFirstName,
      updateLastName,
      updateEmail
    );

    UpdateUserResponseModelPut updateResponse = api.updateUser_PUT(requestBody, token);

    step("Проверка данных", () -> {
      assertThat(updateResponse.username()).isEqualTo(updateUsername);
      assertThat(updateResponse.firstName()).isEqualTo(updateFirstName);
      assertThat(updateResponse.lastName()).isEqualTo(updateLastName);
      assertThat(updateResponse.email()).isEqualTo(updateEmail);
    });
  }
}
