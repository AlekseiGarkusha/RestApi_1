package tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.is;

public class StatusTest {

  // Если разработчик изменит код - то тест упадёт
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
  void bodyStructureTest() {
    given()
      .auth().basic("user1", "1234")
      .when()
      .get("https://selenoid.autotests.cloud/wd/hub/status")
      .then()
      .statusCode(200)
      .body("$", hasKey("value"))
      .body("value", hasKey("message"))
      .body("value", hasKey("ready"));
    System.out.println(RestAssured.baseURI);
  }

  // Если разработчик изменит код - то тест упадёт
  @Test
  void schemaTest() {
    given()
      .auth().basic("user1", "1234")
      .when()
      .get("https://selenoid.autotests.cloud/wd/hub/status")
      .then()
      .statusCode(200)
      .body(matchesJsonSchemaInClasspath("login/statusResponce_login_Schema.json"));
    System.out.println(RestAssured.baseURI);
  }

  @Test
  public void statusResponseValuesTest() {
    given()
      .auth().basic("user1", "1234")
      .when()
      .get("https://selenoid.autotests.cloud/wd/hub/status")
      .then()
      .statusCode(200)
      .body("value.ready", is(true))
      .body("value.message", is("Selenoid 1.11.3 built at 2024-05-25_12:34:40PM"));
  }
}
