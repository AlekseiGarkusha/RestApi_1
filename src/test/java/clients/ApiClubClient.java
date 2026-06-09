package clients;

import io.qameta.allure.Step;

import models.club.ClubBodyModel;
import models.club.ClubResponseModel;

import static io.restassured.RestAssured.given;
import static spec.ClubSpec.successfulClubCreateResponseSpec;
import static spec.LoginSpec.loginRequestSpec;

public class ApiClubClient {

  @Step("Создание Club")
  public ClubResponseModel create(ClubBodyModel body, String token) {
    return given()
      .spec(loginRequestSpec)
      .header("Authorization", "Bearer " + token)
      .body(body)
      .when()
      .post("/clubs/")
      .then()
      .spec(successfulClubCreateResponseSpec)
      .extract()
      .as(ClubResponseModel.class);
  }

  @Step("Получение по id")
  public ClubResponseModel read(ClubBodyModel body, String token, String id) {
    return given()
      .spec(loginRequestSpec)
      .header("Authorization", "Bearer " + token)
      .pathParam("id", id)
      .body(body)
      .when()
      .get("/clubs/{id}")
      .then()
      .statusCode(200)
      .extract()
      .as(ClubResponseModel.class);
  }

  @Step("Обновление клуба")
    public ClubResponseModel update_Patch(ClubBodyModel body, String token, String id) {
      return given()
        .spec(loginRequestSpec)
        .header("Authorization", "Bearer " + token)
        .pathParam("id", id)
        .body(body)
        .when()
        .patch("/clubs/{id}/")
        .then()
        .statusCode(200)
        .extract()
        .as(ClubResponseModel.class);
  }

  @Step("Обновление клуба")
  public ClubResponseModel update_Put(ClubBodyModel body, String token, String id) {
    return given()
      .spec(loginRequestSpec)
      .header("Authorization", "Bearer " + token)
      .pathParam("id", id)
      .body(body)
      .when()
      .put("/clubs/{id}/")
      .then()
      .statusCode(200)
      .extract()
      .as(ClubResponseModel.class);
  }

  @Step("Удаление клуба")
  public void deleteClub(String token, String id) {
    given()
      .spec(loginRequestSpec)
      .header("Authorization", "Bearer " + token)
      .pathParam("id", id)
      .when()
      .delete("/clubs/{id}/")
      .then()
      .statusCode(204);
  }

  @Step("Чтение несуществующего id, после удаления")
  public void getDeteletedIdClub(String token, String id) {
    given()
      .spec(loginRequestSpec)
      .header("Authorization", "Bearer " + token)
      .pathParam("id", id)
      .when()
      .get("/clubs/{id}/")
      .then()
      .statusCode(404);
  }
}
