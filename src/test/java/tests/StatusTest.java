package tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.is;

public class StatusTest {

  // Если разработчик изменит код - то тест упадёт
  @Test
  void statusCodeIs200() {
    given()
      .auth().basic("user1", "1234")
      .when()
      .get("https://selenoid.autotests.cloud/wd/hub/status")
      .then()
      .statusCode(200);
  }

  @Test
  void bodyStructure() {
    given()
      //      .log().all()
      .auth().basic("user1", "1234")
      .when()
      .get("https://selenoid.autotests.cloud/wd/hub/status")
      .then()
      .statusCode(200)
      .body("$", hasKey("value"))
      .body("value", hasKey("message"))
      .body("value", hasKey("ready"));
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
      .body(matchesJsonSchemaInClasspath("statusResponce_Schema.json"));
  }

  @Test
  public void keyValueTest() {
    given()
      //      .log().all()
      //      .log().uri()
      //      .log().method()
      //      .log().headers()
      .auth().basic("user1", "1234")

      .when()
      .get("https://selenoid.autotests.cloud/wd/hub/status")
      .then()
      .statusCode(200)
      .body("value.ready", is(true))
      .body("value.message", is("Selenoid 1.11.3 built at 2024-05-25_12:34:40PM"));
  }
}
