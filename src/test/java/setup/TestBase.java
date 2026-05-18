package setup;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

  @BeforeEach
  public void setUp() {
    RestAssured.baseURI = "http://bookclub.qa.guru:8000";
  }

}
