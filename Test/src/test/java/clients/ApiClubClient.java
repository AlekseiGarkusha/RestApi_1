package clients;

import io.qameta.allure.Step;

import models.club.CreateClubBodyModel;
import models.club.CreateClubResponseModel;
import models.login.LoginResponseModel;

import static io.restassured.RestAssured.given;
import static spec.ClubSpec.successfulClubCreateResponseSpec;
import static spec.LoginSpec.loginRequestSpec;

public class ClubClient {

  @Step("Создание Club")
  public CreateClubResponseModel create(CreateClubBodyModel body, String token) {
    return given()
      .spec(loginRequestSpec)
      .header("Authorization", "Bearer " + token)
      .body(body)
      .when()
      .post("/clubs/")
      .then()
      .spec(successfulClubCreateResponseSpec)
      .extract()
      .as(CreateClubResponseModel.class);
  }

}


