package setup;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

  @BeforeEach
  public void setUp() {
    RestAssured.baseURI = "https://book-club.qa.guru";
  }

}
