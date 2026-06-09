package tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class WhHubStatusTest extends TestBase {

  @Test
  void authStatusTest() {
    given()
      .auth().basic("user1", "1234")
      .when()
      .get("https://selenoid.autotests.cloud/wd/hub/status")
      .then()
      .statusCode(200);
  }

  @Test
  void invalidLoginTest() {
    given()
      .auth().basic("user", "1234")
      .when()
      .get("https://selenoid.autotests.cloud/wd/hub/status")
      .then()
      .statusCode(401);
  }

  @Test
  void invalidPassTest() {
    given()
      .auth().basic("user1", "123")
      .when()
      .get("https://selenoid.autotests.cloud/wd/hub/status")
      .then()
      .statusCode(401);
  }

}
