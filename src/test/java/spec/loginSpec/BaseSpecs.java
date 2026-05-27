package spec.loginSpec;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.http.ContentType.JSON;

public class BaseSpecs {

  public static RequestSpecification baseRequestSpec =
    new RequestSpecBuilder()
      .setBasePath("/api/v1")
      .setContentType(ContentType.JSON)
      .addFilter(new AllureRestAssured())
      .build();
}