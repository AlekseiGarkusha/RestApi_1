package tests;

import helpers.GenerateRandomSeries;
import models.login.LoginBodyModel;
import models.registration.create.OnlyPasswordResponseModel;
import models.registration.create.OnlyUserNameResponseModel;
import models.registration.create.SuccessfulRegistrationResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationTests extends TestBase {

  String username = "qaguru" + GenerateRandomSeries.generateRandomSeries();
  String password = "qaguru123";
  String existingUsername = "qaguru8";

  @Test
  @DisplayName("Проверка на создание нового юзера")
  void createNewUserTest() {
    LoginBodyModel loginData = step("Предусловия", () -> new
      LoginBodyModel(username, password));

    SuccessfulRegistrationResponseModel registrationResponse =
      step("шаги", () -> api.createNewUser(loginData));

    step("проверки", () -> {
      String actualUsername = registrationResponse.username();
      assertThat(actualUsername).isEqualTo(username);
      assertThat(registrationResponse.firstName()).isEqualTo("");
      assertThat(registrationResponse.lastName()).isEqualTo("");
      assertThat(registrationResponse.email()).isEqualTo("");
    });
  }

  @Test
  @DisplayName("Проверка на дубликат юзера по существующему 'username'")
  void successfulRegistrationTest_ExistingUser() {
    LoginBodyModel loginData = step("Предусловия", () ->
      new LoginBodyModel(existingUsername, password));

    List<String> expectedMessage = List.of("A user with that username already exists.");

    OnlyUserNameResponseModel registrationResponse = step("шаги", () ->
      api.testBlankLogin(loginData));

    step("проверки", () -> {
      assertEquals(expectedMessage, registrationResponse.username());});
  }

  @Test
  @DisplayName("Проверка на пустой логин")
  void successfulRegistrationTest_EmptyLogin() {
    LoginBodyModel loginData = step("Предусловия", () ->
      new LoginBodyModel("", password));

    List<String> expectedMessage = List.of("This field may not be blank.");

    OnlyUserNameResponseModel registrationResponse = step("шаги", () ->
      api.testBlankLogin(loginData));

    step("проверки", () -> {
      assertEquals(expectedMessage, registrationResponse.username());});
  }

  @Test
  @DisplayName("Проверка на пустой пароль")
  void successfulRegistrationTest_BlankPassword() {
    LoginBodyModel loginData = step("Предусловия", () ->
      new LoginBodyModel(username, ""));

    OnlyPasswordResponseModel registrationResponse = step("Шаги",
      () -> api.testBlankPassword(loginData));

    step("Проверки", () -> {
      List<String> expectedMessage = List.of("This field may not be blank.");
      assertEquals(expectedMessage, registrationResponse.password());
    });
  }

  @Test
  @DisplayName("Проверка на невалидный логин")
  void successfulRegistrationTest_WrongLogin() {
    LoginBodyModel loginData = step("Предусловия",
      () -> new LoginBodyModel("!!@#!@#", password));

    OnlyUserNameResponseModel registrationResponse = step("шаги",
      () -> api.testBlankOrWrongLogin(loginData));

    step("проверки", () -> {
      List<String> expectedMessage = List.of(
        "Enter a valid username. This value may contain only letters, numbers, and @/./+/-/_ characters.");
      assertEquals(expectedMessage, registrationResponse.username());
    });
  }
}
