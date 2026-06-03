package clients;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public abstract class ApiClient {

  protected static final String BASE_PATH = "/api/v1";

  protected RequestSpecification request() {
    return given()
      .log().all()
      .contentType(ContentType.JSON)
      .basePath(BASE_PATH);
  }
}
