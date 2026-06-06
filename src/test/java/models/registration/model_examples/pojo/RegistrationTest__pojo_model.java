package models.registration.model_examples.pojo;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasKey;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationTest__pojo_model {

  @Test
  void totalAmountTest_withResponseLogs() {
    get("https://selenoid.autotests.cloud/status")
      .then()
      .log().all()
      .body("total", is(5));
  }

  @Test
  void totalAmountTest_withAllLogs() {
    given()
      .when()
      .get("https://selenoid.autotests.cloud/status")
      .then()
      .log().all()
      .body("total", is(5));
  }

  @Test
  void totalAmount200Test() {
    given()
      .log().all()
      .when()
      .get("https://selenoid.autotests.cloud/status")
      .then()
      .log().all()
      .statusCode(200)
      .body("total", is(5));
  }

  @Test
  void fieldsTest() {
    given()
      .log().all()
      .when()
      .get("https://selenoid.autotests.cloud/status")
      .then()
      .log().all()
      .statusCode(200)
      .body("", hasKey("total"))
      .body("", hasKey("used"))
      .body("", hasKey("queued"))
      .body("", hasKey("pending"))
      .body("", hasKey("browsers"));
  }

  @Test
  void browserVersionTest() {
    given()
      .log().all()
      .when()
      .get("https://selenoid.autotests.cloud/status")
      .then()
      .log().all()
      .statusCode(200)
      .body("browsers.chrome", hasKey("127.0"))
      .body("browsers.chrome", hasKey("128.0"));
  }

  @Test
  void successfulRegistrationTest_with_pojo() {
    Faker faker = new Faker();
    String username = faker.name().firstName();
    String password = faker.name().firstName();

    RegistrationBodyPojoModel data = new RegistrationBodyPojoModel();

    data.setUsername(username);
    data.setPassword(password);

//    String data = "{\"username\": \"" + userName + "\"," + "\"password\": \""+ password +"\"}";
      given()
        .body(data)
        .log().all()
        .header("Content-Type", "application/json")
        .contentType(ContentType.JSON)
        .accept(ContentType.JSON)
        .when()
        .post("https://book-club.qa.guru/api/v1/users/register/")
        .then()
        .log().all()
        .statusCode(201)
        .body("username", is(username));

//    assertEquals(username, registrationResponseBodyPojoModel.getUserName());
  }

  @Test
  void successfulRegistrationResponseTest_with_pojo() {
    Faker faker = new Faker();
    String username = faker.name().firstName();
    String password = faker.name().firstName();

    RegistrationBodyPojoModel data = new RegistrationBodyPojoModel();

    data.setUsername(username);
    data.setPassword(password);

//    String data = "{\"username\": \"" + userName + "\"," + "\"password\": \""+ password +"\"}";

    RegistrationResponseBodyPojoModel registrationResponseBodyPojoModel =
      given()
        .body(data)
        .log().all()
        .header("Content-Type", "application/json")
        .contentType(ContentType.JSON)
        .accept(ContentType.JSON)
        .when()
        .post("https://book-club.qa.guru/api/v1/users/register/")
        .then()
        .log().all()
        .statusCode(201)
        .extract()
        .as(RegistrationResponseBodyPojoModel.class);

    assertEquals(username, registrationResponseBodyPojoModel. getUsername());
  }


}
