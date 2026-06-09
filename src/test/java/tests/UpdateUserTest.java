package tests;

import helpers.GenerateRandomSeries;
import models.login.LoginBodyModel;
import models.login.LoginResponseModel;
import models.login.UpdateResponseModel_Patch;
import models.login.UpdateResponseModel_Put;
import models.registration.create.SuccessfulRegistrationResponseModel;
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
    updateEmail = "user12@gmail.com",
    updateAddr = "testAdrr",
    updateId = "";

  /// PATCH
  @Test
  @DisplayName("Тест - обновление данных пользователя - PATCH")
  void updateUser_PATCH() {
    LoginBodyModel userData = new LoginBodyModel(testUsername, password);
    UpdateResponseModel_Patch updateUserData = new UpdateResponseModel_Patch(
      updateUsername,
      updateFirstName,
      updateLastName,
      updateEmail,
      updateAddr,
      updateId);

    SuccessfulRegistrationResponseModel registrationResponse = api.createNewUser(userData);

    LoginResponseModel loginResponse = api.login(userData);

    String token = loginResponse.access();

    UpdateResponseModel_Patch updateResponseModel = api.updateUser_PATCH(updateUserData, token);

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

    SuccessfulRegistrationResponseModel registrationResponse = api.createNewUser(userData);

    LoginResponseModel loginResponse = api.login(userData);
    String token = loginResponse.access();

    UpdateResponseModel_Put updateResponse = api.updateUser_PUT(updateUserDataPut, token);

    step("Проверка данных", () -> {
      assertThat(updateResponse.firstname()).isEqualTo(updateFirstName);
    });
  }
}
