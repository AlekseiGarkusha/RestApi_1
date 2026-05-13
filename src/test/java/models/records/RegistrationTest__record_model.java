package models.records;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import models.lombok.RegistrationBodyLombokModel;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationTest__record_model {

  @Test
  public void successfulRegistrationTest_with_record() {
    Faker faker = new Faker();

    String userName = faker.name().firstName();
    String password = faker.name().firstName();

//    String data = "{\"username\": \"" + userName + "\"," + "\"password\": \""+ password +"\"}";

//    RegistrationBodyPojoModel data = new RegistrationBodyPojoModel();
//    data.setUserName(userName);
//    data.setPassword(password);

//    RegistrationBodyLombokModel data = new RegistrationBodyLombokModel(userName, password);

//    RegistrationBodyRecordModel registrationBodyRecordModel =
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
//      .extract()
//      .as(RegistrationBodyRecordModel.class);
//
//    assertEquals(userName, registrationBodyRecordModel.responce());
//  }
  }

}
