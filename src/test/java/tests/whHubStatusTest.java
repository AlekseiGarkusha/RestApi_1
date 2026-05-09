package tests;

import org.junit.jupiter.api.Test;
import setup.TestBase;

import static io.restassured.RestAssured.given;

public class whHubStatusTest extends TestBase {

  @Test
  void bodyStructure() {
    given()
      .auth().basic("user1", "1234")
      .log().all()
      .when()
      .get("/wd/hub/status")
      .then()
      .log().all()
      .statusCode(401);
  }

  @Test
  void invalidLogin() {
    given()
      .auth().basic("user", "1234")
      .when()
      .get("https://selenoid.autotests.cloud/wd/hub/status")
      .then()
      .statusCode(401);

  }

  @Test
  void invalidPass() {
    given()
      .auth().basic("user1", "123")
      .when()
      .get("https://selenoid.autotests.cloud/wd/hub/status")
      .then()
      .statusCode(401);
  }

}
