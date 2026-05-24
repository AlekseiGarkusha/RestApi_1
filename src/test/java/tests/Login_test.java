package tests;

import models.login.LoginBodyModel;
import models.login.LoginResponseModel;
import models.login.WrongCredantionalsLoginResponseModel;
import models.registration.model_examples.WrongRegistrationsValueIsNull;
import org.junit.jupiter.api.Test;
import setup.TestBase;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static spec.loginSpec.LoginSpec.*;
import static spec.loginSpec.RegistrationSpec.wrongRegistrationEmptyValuesSpec;

public class Login_test extends TestBase {

  String username = "qaguru";
  String password = "qaguru123";
  String wrongUsername = "qaguru888";
  String wrongPassword = "qaguru888";

  @Test
  void successfulRegistrationTest() {
    LoginBodyModel loginData = new LoginBodyModel(username, password);

    LoginResponseModel loginResponse =
    given()
      .spec(loginRequestSpec)
      .body(loginData)
      .basePath("/api/v1")
      .when()
      .post("/users/register/")
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
  void wrongRegistrationTest_wrongPassword() {
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

  @Test
  void wrongRegistrationTest_wrongUsername() {
    LoginBodyModel loginData = new LoginBodyModel(wrongUsername, password);

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

  @Test
  void wrongRegistrationTest_emptyFields() {
    LoginBodyModel loginData = new LoginBodyModel("", "");

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

  @Test
  void wrongRegistrationTest_nullValues() {
    LoginBodyModel loginData = new LoginBodyModel(null, null);

    WrongRegistrationsValueIsNull loginResponse = given(loginRequestSpec)
      .body(loginData)
      .when()
      .post("/auth/token/")
      .then()
      .spec(wrongRegistrationEmptyValuesSpec)
      .extract().as(WrongRegistrationsValueIsNull.class);

    String expectedUsernameError = "[This field may not be null.]";
    String actualActualUsernameError = String.valueOf(loginResponse.username());
    assertThat(actualActualUsernameError).isEqualTo(expectedUsernameError);

    String expectedPasswordError = "[This field may not be null.]";
    String actualActualPasswordError = String.valueOf(loginResponse.password());
    assertThat(expectedPasswordError).isEqualTo(actualActualPasswordError);
  }

}
