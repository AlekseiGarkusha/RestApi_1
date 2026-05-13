package models.pojo;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasKey;

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
      .body("total",is(5));
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
  void successfulRegistrationTest_with_lombok() {
    Faker faker = new Faker();
    RegistrationBodyPojoModel data = new RegistrationBodyPojoModel();

//   data.setUserName(data.userName);
//   data.set

//    String data = "{\"username\": \"" + userName + "\"," + "\"password\": \""+ password +"\"}";

//    RegistrationBodyPojoModel data = new RegistrationBodyPojoModel();
//    data.setUserName(userName);
//    data.setPassword(password);


//    given()
//      .body(data)
//      .log().all()
//      .header("Content-Type", "application/json")
//      .contentType(ContentType.JSON)
//      .accept(ContentType.JSON)
//      .when()
//      .post("http://bookclub.qa.guru:8000/api/v1/users/register/")
//      .then()
//      .log().all()
//      .statusCode(502)
//      .body("username", is(userName))
//      .body("id", notNullValue());
//  }

  }
}
