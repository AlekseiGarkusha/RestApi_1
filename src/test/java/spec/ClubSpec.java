package spec;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.filter.log.LogDetail.ALL;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.notNullValue;

public class ClubSpec {

  public static ResponseSpecification successfulClubCreateResponseSpec = new ResponseSpecBuilder()
    .log(ALL)
    .expectStatusCode(201)
    .expectBody(matchesJsonSchemaInClasspath("club/clubCreate_response_schema.json"))
    .expectBody("id", notNullValue())
    .expectBody("bookTitle", notNullValue())
    .expectBody("bookAuthors", notNullValue())
    .expectBody("publicationYear", notNullValue())
    .expectBody("description", notNullValue())
    .expectBody("owner", notNullValue())
    .expectBody("members", notNullValue())
    .build();

}
