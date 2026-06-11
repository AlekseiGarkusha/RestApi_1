package tests;

import models.login.LoginBodyModel;
import models.login.LoginResponseModel;

import models.reviews.ReviewsBodyModel;
import models.reviews.ReviewsResponseModel;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static spec.LoginSpec.loginRequestSpec;
import static spec.LoginSpec.successfulLoginResponseSpec;

public class ReviewsTests extends TestBase {

  // todo Get reviews
  // создать api - обзоры
  // cоздать request / response

  String
    club, review, assessment,
    description, readPages;

  Integer count;
  String next,previousl;

  @Test
  public void getReviewsTests() {
    String username = "qaguru777";
    String password = "qaguru123";

    LoginBodyModel userData = new LoginBodyModel(username, password);

    LoginResponseModel loginResponse = api.login(userData);
    String token = loginResponse.access();

    ReviewsResponseModel responseData =
      given()
        .spec(loginRequestSpec)
        .header("Authorization", "Bearer " + token)
        .when()
        .get("/clubs/reviews/")
        .then()
        .extract()
        .as(ReviewsResponseModel.class);
  }

  // todo Post reviews
  // todo Get id reviews
  // todo Put id reviews
  // todo Patch id reviews
  // todo Delete id reviews

  /**
   * club
   * review
   * assessment
   * readPages
   *   "club": [
   *         "This field is required."
   *     ],
   *     "review": [
   *         "This field is required."
   *     ],
   *     "assessment": [
   *         "This field is required."
   *     ],
   *     "readPages": [
   *         "This field is required."
   *     ]
   *
   */

}
