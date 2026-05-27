//package tests;
//
//import io.restassured.http.ContentType;
//import models.login.LoginBodyModel;
//import models.login.LoginResponseModel;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import static io.restassured.RestAssured.given;
//import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
//import static spec.loginSpec.LoginSpec.loginRequestSpec;
//
//public class UpdateUserTest {
//
//  String username = "updateUsername";
//  String firstName = "updateFirstBame";
//  String lastName = "updateLastname";
//  String email = "updateEmail";
//  String password = "updateEmail";
//
//  ///  PATCH
//  @Test
//  @DisplayName("Тест - обновление данных пользователя")
//  void updateUser_test() {
//    LoginBodyModel loginData = new LoginBodyModel(username, password);
//
//    LoginResponseModel loginResponse =
//      given()
//        .spec(loginRequestSpec)
//        .body(loginData)
//        .basePath("/api/v1")
//        .when()
//        .post("/auth/token/")
//        .then()
//        .statusCode(200)
//        .extract().as(LoginResponseModel.class);
//
//    LoginResponseModel loginResponse =
//      given()
//        .log().all()
//        .contentType(ContentType.JSON)
//        .body(loginData)
//        .basePath("/api/v1")
//        .when()
//        .patch("/users/me/")
//        .then()
//        .log().all()
//        .statusCode(200)
//        .body(matchesJsonSchemaInClasspath(
//          "update/updateUser_Schema.json"))
//        .extract().as(LoginResponseModel.class);
//
//    String actualUsername = UpdateResponse.username();
//    String actualFirstName = UpdateResponse.firstName();
//    String actualLastName = UpdateResponse.lastName();
//    String actualEmail = UpdateResponse.email();
//
//    String expectedUsername = updateData.username();
//    String expectedFirstName = updateData.firstName();
//    String expectedLastName = updateData.lastName();
//    String expectedEmail = updateData.email();
//
//    assertThat(actualUsername).isEqualTo(expectedUsername);
//    assertThat(actualFirstName).isEqualTo(expectedFirstName);
//    assertThat(actualLastName).isEqualTo(expectedLastName);
//    assertThat(actualEmail).isEqualTo(expectedEmail);
//
//    String expectedDetailError = "Authentication credentials were not provided.";
//  }
//}
