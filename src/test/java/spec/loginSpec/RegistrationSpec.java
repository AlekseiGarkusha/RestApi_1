package spec.loginSpec;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.CoreMatchers;

import static io.restassured.filter.log.LogDetail.ALL;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.core.IsNull.notNullValue;

public class RegistrationSpec {

  public static ResponseSpecification classicRegistrationSpec =
    new ResponseSpecBuilder()
      .log(ALL)
      .expectStatusCode(201)
//      .expectBody(matchesJsonSchemaInClasspath(
//        "registration/successfull_registration_response_createUser_Schema.json"))
      .expectBody("id", notNullValue())
      .expectBody("username", notNullValue())
      .expectBody("remoteAddr", notNullValue())
      .build();

  public static ResponseSpecification wrongRegistrationEmptyValuesSpec = new ResponseSpecBuilder()
    .log(ALL)
    .expectStatusCode(400)
    .expectBody(matchesJsonSchemaInClasspath("registration/negative_registration_response_test_emptyValues.json"))
    .expectBody("username", CoreMatchers.notNullValue())
    .expectBody("password", CoreMatchers.notNullValue())
    .build();

}
