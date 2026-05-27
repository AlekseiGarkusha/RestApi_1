package models.registration.model_examples.records;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationTestRecordModel {

  @Test
  public void successfulRegistrationTest_with_record() {
    String username = "testUser";
    String password = "123456";

    RegistrationBodyRecordModel data = new RegistrationBodyRecordModel(username, password);

    RegistrationResponseRecordsModel registrationResponseRecordsModel =
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
      .extract()
      .as(RegistrationResponseRecordsModel.class);

    assertEquals(username, data.username());
  }

}
