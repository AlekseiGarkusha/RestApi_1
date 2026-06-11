package models.examples.lombok;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

public class RegistrationTestLombokModel {

  @Disabled("temporarily disabled")
  @Test
  void successfulRegistrationTest_with_lombok() {
    Faker faker = new Faker();
    RegistrationBodyLombokModel data = new RegistrationBodyLombokModel();

    String username = faker.name().username();
    String password = faker.internet().password();

    data.setUsername(username);
    data.setPassword(password);

//    String data = "{\"username\": \"" + userName + "\"," + "\"password\": \""+ password +"\"}";

//    RegistrationBodyPojoModel data = new RegistrationBodyPojoModel();
//    data.setUserName(userName);
//    data.setPassword(password);

    given()
      .body(data)
      .log().all()
      .header("Content-Type", "application/json")
      .contentType(ContentType.JSON)
      .accept(ContentType.JSON)
      .when()
      .post("http://bookclub.qa.guru:8000/api/v1/users/register/")
      .then()
      .log().all()
      .statusCode(201)
      .body("username", is(username))
      .body("id", notNullValue());
  }
}
