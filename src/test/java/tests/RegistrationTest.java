package tests;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import models.pojo.RegistrationBodyLombokModel;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

public class RegistrationTest {

  @Test
  void successfulRegistrationTest_with_POJO() {
    Faker faker = new Faker();

    String userName = faker.name().firstName();
    String password = faker.name().firstName();

//    String data = "{\"username\": \"" + userName + "\"," + "\"password\": \""+ password +"\"}";

//    RegistrationBodyPojoModel data = new RegistrationBodyPojoModel();
//    data.setUserName(userName);
//    data.setPassword(password);

    RegistrationBodyLombokModel data = new RegistrationBodyLombokModel();

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
      .statusCode(502)
      .body("username", is(userName))
      .body("id", notNullValue());
  }


}
