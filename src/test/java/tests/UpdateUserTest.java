package tests;

import helpers.GenerateRandomSeries;
<<<<<<< HEAD
import models.login.*;
import models.registration.create.SuccessfulRegistrationResponseModel;
import models.user.UpdateUserBodyModel_Patch;
import models.user.UpdateUserBodyModel_Put;
import models.user.UpdateUserResponseModel_Patch;
import models.user.UpdateUserResponseModel_Put;
=======
import models.login.LoginBodyModel;
import models.login.LoginResponseModel;
import models.login.UpdateResponseModel_Patch;
import models.login.UpdateResponseModel_Put;
import models.registration.create.SuccessfulRegistrationResponseModel;
>>>>>>> 9ac347cd5ae1262a6a64bfd24aea01f7114b914a
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
<<<<<<< HEAD
    updateEmail = "userG-12@yandex.ru",
=======
    updateEmail = "user12@gmail.com",
>>>>>>> 9ac347cd5ae1262a6a64bfd24aea01f7114b914a
    updateAddr = "testAdrr",
    updateId = "";

  @Test
  @DisplayName("Тест - обновление данных пользователя - PATCH")
  void updateUser_PATCH() {
    LoginBodyModel userData = new LoginBodyModel(testUsername, password);
<<<<<<< HEAD
    UpdateUserBodyModel_Patch requestBody = new UpdateUserBodyModel_Patch(
      updateUsername,
      updateFirstName,
      updateLastName,
      updateEmail);
=======
    UpdateResponseModel_Patch updateUserData = new UpdateResponseModel_Patch(
      updateUsername,
      updateFirstName,
      updateLastName,
      updateEmail,
      updateAddr,
      updateId);
>>>>>>> 9ac347cd5ae1262a6a64bfd24aea01f7114b914a

    SuccessfulRegistrationResponseModel registrationResponse = api.createNewUser(userData);

    LoginResponseModel loginResponse = api.login(userData);

    String token = loginResponse.access();

<<<<<<< HEAD
    UpdateUserResponseModel_Patch updateResponseModel = api.updateUser_PATCH(requestBody, token);
=======
    UpdateResponseModel_Patch updateResponseModel = api.updateUser_PATCH(updateUserData, token);
>>>>>>> 9ac347cd5ae1262a6a64bfd24aea01f7114b914a

    System.out.println(updateEmail);

    step("Проверка данКороных", () -> {
      assertThat(updateResponseModel.username()).isEqualTo(updateUsername);
      assertThat(updateResponseModel.firstName()).isEqualTo(updateFirstName);
      assertThat(updateResponseModel.lastName()).isEqualTo(updateLastName);
      assertThat(updateResponseModel.email()).isEqualTo(updateEmail);
    });
  }

<<<<<<< HEAD
=======

  /// PUT
>>>>>>> 9ac347cd5ae1262a6a64bfd24aea01f7114b914a
  @Test
  @DisplayName("Тест - обновление данных пользователя PUT")
  void updateUser_PUT() {
    LoginBodyModel userData = new LoginBodyModel(testUsername, password);
    UpdateResponseModel_Put updateUserDataPut = new UpdateResponseModel_Put(
      updateUsername, updateFirstName,
      updateLastName, updateEmail);

<<<<<<< HEAD
    api.createNewUser(userData);
=======
    SuccessfulRegistrationResponseModel registrationResponse = api.createNewUser(userData);
>>>>>>> 9ac347cd5ae1262a6a64bfd24aea01f7114b914a

    LoginResponseModel loginResponse = api.login(userData);
    String token = loginResponse.access();

<<<<<<< HEAD
    UpdateUserBodyModel_Put requestBody = new UpdateUserBodyModel_Put(
      updateUsername,
      updateFirstName,
      updateLastName,
      updateEmail
    );

    UpdateUserResponseModel_Put updateResponse = api.updateUser_PUT(requestBody, token);

    step("Проверка данных", () -> {
      assertThat(updateResponse.username()).isEqualTo(updateUsername);
      assertThat(updateResponse.firstName()).isEqualTo(updateFirstName);
      assertThat(updateResponse.lastName()).isEqualTo(updateLastName);
      assertThat(updateResponse.email()).isEqualTo(updateEmail);
=======
    UpdateResponseModel_Put updateResponse = api.updateUser_PUT(updateUserDataPut, token);

    step("Проверка данных", () -> {
      assertThat(updateResponse.firstname()).isEqualTo(updateFirstName);
>>>>>>> 9ac347cd5ae1262a6a64bfd24aea01f7114b914a
    });
  }
}
