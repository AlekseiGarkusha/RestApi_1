package clients;

import io.qameta.allure.Step;
import models.login.LoginResponseModel;
import models.reviews.ReviewsResponseModel;

import static io.restassured.RestAssured.given;
import static spec.ClubSpec.successfulClubCreateResponseSpec;
import static spec.LoginSpec.loginRequestSpec;

public class ApiReviewClient {

  @Step("Получение всех отзывов")
  public ReviewsResponseModel getReview(LoginResponseModel body, String token) {
    return given()
      .spec(loginRequestSpec)
      .header("Authorization", "Bearer " + token)
      .body(body)
      .when()
      .get("/clubs/reviews/")
      .then()
      .spec(successfulClubCreateResponseSpec)
      .extract()
      .as(ReviewsResponseModel.class);
  }

}
